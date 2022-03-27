package academy.lgs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import academy.lgs.domain.Student;
import academy.lgs.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/registration" )
	public String addStudent(@RequestParam(required = false) Integer age, @RequestParam String firstName, @RequestParam String lastName, Model model) {
		Student student = new Student(firstName, lastName, age);
		studentService.save((Student) student);
		return "profile";
	}
	
	@GetMapping("/profile" )
	public String viewpProfile(HttpServletRequest req) {
		Student student = studentService.findAll().stream().findFirst().orElse(null);
		req.setAttribute("student", student);
		return "profile_show";
		
	}
}
