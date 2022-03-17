package academy.lgs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import academy.lgs.domain.University;

@Repository
public interface UniversityRepository extends  JpaRepository<University, Long> , CrudRepository<University, Long>{

}
