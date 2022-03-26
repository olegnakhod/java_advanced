package academy.lgs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import academy.lgs.domain.Student;
import academy.lgs.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/profile")
	public String init(HttpServletRequest req) {
		Student student = studentService.findAll().stream().findAny().orElse(null);
		req.setAttribute("students", student);
		req.setAttribute("mode", "STUDENT_PROFILE");
		return "index";
	}
	
	@GetMapping("/")
	public String newParticipant(HttpServletRequest req) {
		req.setAttribute("mode", "STUDENT_CREATE");
		return "index";
	}
	
	@PostMapping("/save")
	public String registerStudent(@ModelAttribute Student student,HttpServletRequest req) {
		studentService.save(student);
		req.setAttribute("mode", "STUDENT_PROFILE");
		studentService.save(student);
		return "index";
	}
}
