package academy.lgs.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import academy.lgs.domain.FileMultipart;
import academy.lgs.domain.Student;
import academy.lgs.dto.MultipartUploadResponse;
import academy.lgs.service.FileMultipartService;
import academy.lgs.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	FileMultipartService fileMultipartService;
	
	@GetMapping("/")
	public ModelAndView newStudent(HttpServletRequest req) {
		req.setAttribute("mode", "STUDENT_CREATE");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("studentFromServer", new Student());
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@PostMapping("/addStudent")
	public ModelAndView addStudent(@ModelAttribute("studentFromServer") Student student,HttpServletRequest req) {
		req.setAttribute("mode", "STUDENT_VIEW");
		studentService.save(student);
		req.setAttribute("student", studentService.findById(student.getId()));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
	

	@PostMapping("/uploadFile")
	public MultipartUploadResponse uploadFile(@RequestParam("file") MultipartFile file,HttpServletRequest req) throws IOException {
		FileMultipart fileMultipart = fileMultipartService.storeFile(file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileMultipart.getId()).toUriString();
	
		return new MultipartUploadResponse(fileMultipart.getFileName(), fileDownloadUri, file.getContentType(),
				file.getSize());
	}

	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<Resource> downlaodFile(@PathVariable String fileId) throws FileNotFoundException {
		FileMultipart fileMultipart = fileMultipartService.getFile(fileId);

		return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileMultipart.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileMultipart.getFileName() + "\"")
                .body(new ByteArrayResource(fileMultipart.getData()));
	}

}
