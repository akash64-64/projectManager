package com.HomeChallenge.ProjectManager.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.HomeChallenge.ProjectManager.Model.projectModel;
import com.HomeChallenge.ProjectManager.Model.todoModel;
import com.HomeChallenge.ProjectManager.Model.userModel;
import com.HomeChallenge.ProjectManager.Repository.ProjectRepository;
import com.HomeChallenge.ProjectManager.Repository.userRepository;
import com.HomeChallenge.ProjectManager.Service.ProjectManagerService;

import jakarta.servlet.http.HttpSession;

@Controller
public class projectManagerController {
	
	@Autowired
	private ProjectManagerService service;
	
	@Autowired
	private userRepository repo;
	
//	@PostMapping
//	public String createProject(@RequestBody projectModel project) {
//		
//		service.createProject(project);
//		return "Project Created Successfully";
//	}
	
	@GetMapping
	public List<projectModel> allProjectdetails(){
		
		return  service.getAllProject();
	}
	
	@GetMapping("{projectId}")
	public projectModel getAProject(@PathVariable("projectId")Long Pid) {
		
		return service.getProject(Pid);
	}
	
//	@PostMapping("/addtodo")
//	public String addTodo(@RequestBody todoModel todo) {
//		
//		service.addTodos(todo);
//		return "todo added Successfully";
//	}
	
	@GetMapping("/home")
	public String homepage(Model model,HttpSession session) {
		String username = (String)session.getAttribute("username");
		userModel user = repo.findByUsername(username);
		if(user!=null) {
		model.addAttribute("project", service.getProjectofUser(user.getUserId()));
		return "home";
		}else return "index";
	}
	@RequestMapping("/index")
	public String index() {
//		String name = (String) session.getAttribute("username");
//		userModel user = repo.findByUsername(name);
//		if(user!=null) {
//			
//			return "home";
//		}
		return "index";
	}
	
	@RequestMapping("/getstarted")
	public String start(HttpSession session) {
		String name = (String) session.getAttribute("username");
		userModel user = repo.findByUsername(name);
		if(user!=null) {
			
			return "redirect:/home";
		}else {
			
			return"/register";
		}
		
	}
	
	@RequestMapping("/createproject")
	public String createPro(HttpSession session) {
		String name = (String) session.getAttribute("username");
		userModel existUser = repo.findByUsername(name);
		if(existUser!=null) {
		return"createproject";}
		else return "register";
	}
	
	@RequestMapping("/send")
	public String success(@RequestParam("title")String title,HttpSession session) {
		projectModel project = new projectModel();
		String name = (String) session.getAttribute("username");
		userModel user = repo.findByUsername(name);
			service.createProject(project,title,user);
			return"redirect:/home";		
	}
	
	@RequestMapping("/register")
	public String signin() {
		
		return "register";
	}
	@RequestMapping("/log")
	public String Login() {
		
		return "login";
	}
	
	@PostMapping("/signin")
	public String sign(@RequestParam(required=false,name="uname")String name,@RequestParam(required=false,name="pwd")String password,@RequestParam(required=false,name="cpwd")String passwordConfirm,Model model) {
		userModel existingUser = repo.findByUsername(name);
		if(existingUser!=null) return"nameExist";
		
	if(password.equals(passwordConfirm)){
		userModel user = new userModel(name,password);
		service.signinUser(user);
		return"login";
	}else {
		return "register";
	}
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String logIn(@RequestParam(required=false,name="name")String username,@RequestParam(required=false,name="pass")String password,HttpSession session) {
		
		userModel existingUser = repo.findByUsername(username);
		if(existingUser!=null && password.equals(existingUser.getPassword())) {
			session.setAttribute("username", existingUser.getUsername());
			
			return "redirect:/home";
		}
		else {
			return "log";
					}
	}
	
	@RequestMapping("/change/{id}")
	public String Change(@RequestParam("title")String title,@PathVariable("id")Long id) {
		
		service.updateTitle(title, id);
		return "redirect:/todo/{id}";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:/index";
	}
}
