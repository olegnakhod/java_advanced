package academy.lgs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.lgs.domain.Student;
import academy.lgs.repository.StudentRepository;
import academy.lgs.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired(required=true)
	private StudentRepository studentRepo;
	
	@Override
	public Student save(Student student) {
		return studentRepo.saveAndFlush(student);
	}

	@Override
	public Student findById(Integer id) {
		return studentRepo.getOne(id);
	}

	@Override
	public Student update(Student student) {
		return studentRepo.saveAndFlush(student);
	}

	@Override
	public void deleteById(Integer id) {
		studentRepo.deleteById(id);
		
	}

	@Override
	public List<Student> findAll() {
		return studentRepo.findAll();
	}
}
