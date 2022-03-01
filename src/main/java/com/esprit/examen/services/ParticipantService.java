package com.esprit.examen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.Participant;
import com.esprit.examen.entities.Session;
import com.esprit.examen.repositories.ParticipantRepository;

@Service
public class ParticipantService implements IParticipantService {

	@Autowired
	ParticipantRepository participantRepository;
	
	@Override
	public Long addParticipant(Participant participant) {
		participantRepository.save(participant);
		return participant.getId();
	}

	@Override
	public Long modifierParticipant(Participant participant) {
		participantRepository.save(participant);
		return participant.getId();
	}

	@Override
	public void supprimerParticipant(Long participantId) {
		participantRepository.deleteById(participantId);
	}
	
	@Override
	public List<Participant> getParticipants() {
		return participantRepository.findAll();
	}

	
}
