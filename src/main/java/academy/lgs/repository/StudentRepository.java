package academy.lgs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.lgs.domain.Student;

public interface StudentRepository extends  JpaRepository<Student, Integer>  {

}
