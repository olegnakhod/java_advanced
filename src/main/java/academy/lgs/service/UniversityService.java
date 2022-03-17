package academy.lgs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import academy.lgs.domain.University;

@Service
public interface UniversityService {

	University save(University university);

	University findById(Long id);

	University update(University university);

	void deleteById(Long id);

	List<University> findAll();
	
}
