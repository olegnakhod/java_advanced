package academy.lgs.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import academy.lgs.domain.Student;
import academy.lgs.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/registration" )
	public String addStudent(@ModelAttribute Student student) {
		studentService.save((Student) student);
		return "profile";
	}
	
	@GetMapping("/profile" )
	public void viewProfile(HttpServletResponse response) throws IOException {
		String json = new Gson().toJson(studentService.findLastStudent());
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}
}
