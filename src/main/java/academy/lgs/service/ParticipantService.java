package academy.lgs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.lgs.dao.ParticipantRepo;
import academy.lgs.domain.Participant;

@Service
public class ParticipantService {
	
	@Autowired
	private ParticipantRepo partRepo;

	public List<Participant> findAllParticipants() {
		return partRepo.findAllParticipants();
	}

	public Participant findOne(Integer id) {
		return partRepo.findOne(id);
	}

	public void save(Participant participant) {
		partRepo.save(participant);
	}

	public void delete(Integer id) {
		partRepo.delete(id);
	}
}
