package com.esprit.examen.services;

import java.util.List;

import com.esprit.examen.entities.Participant;

public interface IParticipantService {

	Long addParticipant(Participant participant);

	Long modifierParticipant(Participant participant);

	void supprimerParticipant(Long participantId);

	List<Participant> getParticipants();
}
