package academy.lgs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.lgs.domain.Student;
import academy.lgs.repository.StudentRepository;

@Service
public class StudentService	{

	@Autowired(required=true)
	private StudentRepository studentRepo;
	
	public Student save(Student student) {
		return studentRepo.saveAndFlush(student);
	}

	public Student findById(Integer id) {
		return studentRepo.getOne(id);
	}

	public Student update(Student student) {
		return studentRepo.saveAndFlush(student);
	}

	public void deleteById(Integer id) {
		studentRepo.deleteById(id);
		
	}

	public List<Student> findAll() {
		return studentRepo.findAll();
	}

}
