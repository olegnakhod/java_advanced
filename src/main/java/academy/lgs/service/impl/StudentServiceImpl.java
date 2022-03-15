package academy.lgs.service.impl;

import java.util.List;

import academy.lgs.dao.StudentDao;
import academy.lgs.dao.impl.StudentDaoImpl;
import academy.lgs.domain.Student;
import academy.lgs.service.StudentService;

public class StudentServiceImpl implements StudentService{
	
	private StudentDao std = new StudentDaoImpl();


	@Override
	public Student create(Student t) {
		return std.create(t);
	}

	@Override
	public Student read(Integer id) {
		return std.read(id);
	}

	@Override
	public void update(Integer id) {
		std.update(id);
	}

	@Override
	public void delete(Integer id) {
		std.delete(id);
	}

	@Override
	public List<Student> readAll() {
		return std.readAll();
	}

}
