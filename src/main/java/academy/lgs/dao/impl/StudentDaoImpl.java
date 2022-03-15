package academy.lgs.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import academy.lgs.dao.StudentDao;
import academy.lgs.domain.Student;

@Component
public class StudentDaoImpl implements StudentDao{

	private List<Student> listWithStudent = new ArrayList();
	Scanner scanner = new Scanner(System.in);

	
	public List<Student> getListWithStudent() {
		return this.listWithStudent;
	}

	@Override
	public Student create(Student student) {
		this.listWithStudent.add(student);
		return student;
	}

	@Override
	public Student read(Integer id) {
		Student student = this.listWithStudent.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return student;
	}

	@Override
	public void update(Integer id) {
		Student student = this.listWithStudent.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		System.out.println("Enter age");
		student.setAge(scanner.nextInt());
		System.out.println("Enter name");
		student.setName(scanner.next());
	}

	@Override
	public void delete(Integer id) {
		List<Student> newListWithStudent = this.listWithStudent.stream().filter(x -> x.getId() != id)
				.collect(Collectors.toList());
		this.listWithStudent = newListWithStudent;
	}

	@Override
	public List<Student> readAll() {
		return this.listWithStudent;
	}
	

}
