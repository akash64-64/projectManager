package com.HomeChallenge.ProjectManager.Controller;



import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HomeChallenge.ProjectManager.Model.projectModel;
import com.HomeChallenge.ProjectManager.Model.todoModel;
import com.HomeChallenge.ProjectManager.Repository.ProjectRepository;
import com.HomeChallenge.ProjectManager.Repository.TodoRepository;
import com.HomeChallenge.ProjectManager.Service.TodoService;

@Controller
public class TodoController {
	
	@Autowired
	private TodoService service;
	
	@Autowired
	private ProjectRepository repo;
	
	@Autowired
	private TodoRepository Trepo;
	
	@RequestMapping("/todo/{id}")
	public String Todo(@PathVariable("id")Long id,Model model) {
//		Optional<projectModel> project = repo.findById(id);
//		
//		model.addAttribute("todo", service.getTodoLists(project));
		projectModel project = repo.findByprojectId(id);
		model.addAttribute("project", project);
		model.addAttribute("todo", service.getTodoLists(project));
		model.addAttribute("id", id);
		return "/todo";
	}
	
	@RequestMapping("/addtodos/{id}")
	public String add(@RequestParam("desc")String description,@RequestParam("status")String status,@PathVariable("id")Long id) {
		
		service.addTodo(description, status,id);
		return "redirect:/todo/{id}";
	}
	
	@RequestMapping("/update/{pid}/{id}")
	public String update(@PathVariable("id")Long id,@PathVariable("pid")Long pid,Model model) {
		
		todoModel todo = Trepo.findBytodoId(id);
		model.addAttribute("todo", todo);
		model.addAttribute("id", pid);
		return "update";
	}
	
	@RequestMapping("/updated/{Pid}/{id}")
	public String updated(@PathVariable("id")Long id,@RequestParam("desc")String description,@RequestParam("status")String status,@PathVariable("Pid")Long pid){
		
//		todoModel updatedTodo = Trepo.findBytodoId(id);
		service.updateTodo(id, description, status);
		return "redirect:/todo/{Pid}";
	}
	@RequestMapping("/delete/{pid}/{id}")
	public String delete(@PathVariable("pid")Long pid,@PathVariable("id")Long id) {
		
		service.deleteTodo(id);
		return "redirect:/todo/{pid}";
	}
	
	@RequestMapping("/export-summary/{pid}")
	public ResponseEntity<ByteArrayResource> exportSummary(@PathVariable("pid")Long pid){
		
		projectModel project = repo.findByprojectId(pid);
		String markdownContent= generateSummary(service.getTodoLists(project),project);
		
		byte[] markdownBytes = markdownContent.getBytes(StandardCharsets.UTF_8);
        ByteArrayResource resource = new ByteArrayResource(markdownBytes);
        
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=export_summary.md");
        
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(markdownBytes.length)
                .contentType(MediaType.parseMediaType("text/markdown"))
                .body(resource);

	}
	
	private String generateSummary(List<todoModel> todos,projectModel project) {
		
	int pending=0;
	int completed=0;
	int f=0;
		int total=service.getTodoLists(project).size();
		for(todoModel todocount:todos) {
			
			if(todocount.getStatus().equals("Pending")) {
				pending++;
			}else if(todocount.getStatus().equals("Completed")) {
				completed++;
			}else {f++;}
		}
			
		
		
		StringBuilder markdown = new StringBuilder();
		markdown.append("# ").append(project.getProjectTitle()).append("\n");
		markdown.append("### Summary: ").append(completed).append("/").append(total).append(" completed\n");
		markdown.append("## Pending\n");
		
		for(todoModel todo:todos) {
			if(todo.getStatus().equals("Pending")) {
			markdown.append("- [ ] ").append(todo.getDescription()).append("\n");
			}
		}
		markdown.append("## Completed\n");
		for(todoModel todo:todos) {
			if(todo.getStatus().equals("Completed")) {
			markdown.append("- [x] ").append(todo.getDescription()).append("\n");
			}
		}
//			markdown.append("## Pending\n");
//			if(todo.getStatus().equals("Pending")) {
//				markdown.append("- [] ").append(todo.getDescription()).append("\n");
//			}
//			markdown.append("## Completed\n");
//			if(todo.getStatus().equals("Completed")) {
//				markdown.append("- [x] ").append(todo.getDescription()).append("\n");
//			}
		
		return markdown.toString();
	}
}
