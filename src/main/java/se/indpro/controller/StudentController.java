package se.indpro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class StudentController {
//	@Autowired
//	private StudentService studentService;
//	
	@PostMapping("/")
	@ResponseBody
	public String getAllStudents(HttpServletRequest request){
		return "<h1>"+request.getParameter("name")+" "+request.getParameter("department")+"</h1>";
	}
	
	@GetMapping("/")
	public ModelAndView getForm() {
		ModelAndView modelandView = new ModelAndView();
		modelandView.setViewName("index");
		return modelandView;
	}
//	
//	@PostMapping("/")
//	public void addStudent(@RequestBody Student model) {
//		
//	}
//	
//	@PutMapping
//	public void updateStudent(@RequestBody Student model) {
//		
//	}
//	
//	@DeleteMapping
//	public void deleteStudent() {
//		
//	}
}
