package academy.lgs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import academy.lgs.domain.Student;

@Service
public interface StudentService {
	
	Student save(Student student);

	Student findById(Integer id);

	Student update(Student student);

	void deleteById(Integer id);

	List<Student> findAll();
	
	
}
