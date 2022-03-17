package academy.lgs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.lgs.domain.University;
import academy.lgs.repository.UniversityRepository;
import academy.lgs.service.UniversityService;

@Service
public class UniversityServiceImpl implements UniversityService {
	
	@Autowired(required=true)
	 private UniversityRepository universityRep;

	@Override
	public University save(University university) {
		return universityRep.saveAndFlush(university);
	}

	@Override
	public University findById(Long id) {
		return universityRep.getOne(id);
	}

	@Override
	public University update(University university) {
		return universityRep.saveAndFlush(university);
	}

	@Override
	public void deleteById(Long id) {
		universityRep.deleteById(id);
		
	}

	@Override
	public List<University> findAll() {
		return universityRep.findAll();
	}

}
