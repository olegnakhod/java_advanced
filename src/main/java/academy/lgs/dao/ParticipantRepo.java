package academy.lgs.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import academy.lgs.domain.Level;
import academy.lgs.domain.Participant;

@Repository
public class ParticipantRepo {
	private List<Participant> participants = new ArrayList<>();

	@PostConstruct
	public void init() {
		Participant participant1 = new Participant();
		participant1.setId(1);
		participant1.setName("Oleg");
		participant1.setEmail("oleg@gmail.com");
		participant1.setLevel(Level.L1);
		participant1.setPrimarySkill("Developer");

		Participant participant2 = new Participant();
		participant2.setId(2);
		participant2.setName("Viktor");
		participant2.setEmail("Viktor@gmail.com");
		participant2.setLevel(Level.L2);
		participant2.setPrimarySkill("DevOps");

		Participant participant3 = new Participant();
		participant3.setId(3);
		participant3.setName("Olga");
		participant3.setEmail("Olga@gmail.com");
		participant3.setLevel(Level.L4);
		participant3.setPrimarySkill("HR");

		Participant participant4 = new Participant();
		participant4.setId(4);
		participant4.setName("Sergii");
		participant4.setEmail("sergii@gmail.com");
		participant4.setLevel(Level.L5);
		participant4.setPrimarySkill("Project manager");
		
		participants.add(participant1);
		participants.add(participant2);
		participants.add(participant3);
		participants.add(participant4);
	}

	public List<Participant> findAllParticipants() {
		return participants;
	}

	public Participant findOne(Integer  id) {
		return participants.stream().filter(participant -> participant.getId() == id).findFirst().orElse(null);
	}

	public void save(Participant participant) {
		Participant participantToUpdate = null;

		if (participant.getId() != null) {
			participantToUpdate = findOne(participant.getId());
			int participantIndex = participants.indexOf(participantToUpdate);
			participantToUpdate.setName(participant.getName());
			participantToUpdate.setEmail(participant.getEmail());
			participantToUpdate.setLevel(participant.getLevel());
			participantToUpdate.setPrimarySkill(participant.getPrimarySkill());
			participants.set(participantIndex, participantToUpdate);
		} else {
			// save
			participant.setId(participants.size() + 1);
			participants.add(participant);
		}
	}

	public void delete(Integer id) {
		Iterator<Participant> iter = participants.iterator();
		while (iter.hasNext()) {
			if (iter.next().getId() == id) {
				iter.remove();
			}
		}
	}
}
