package com.esprit.examen.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.examen.entities.Participant;
import com.esprit.examen.services.IParticipantService;

@RestController
public class ParticipantRestController {

	private static final Logger l = LogManager.getLogger(ParticipantRestController.class);
	
	@Autowired
	IParticipantService participantService;
	
	@PostMapping("/ajouterParticipant")
	@ResponseBody
	public Participant ajouterParticipant(@RequestBody Participant participant) {
		participantService.addParticipant(participant);
		return participant;
	}
	
	@PutMapping("/modifierParticipant")
	@ResponseBody
	public Participant modifierParticipant(@RequestBody Participant participant) {
		participantService.modifierParticipant(participant);
		return participant;
	}

	@DeleteMapping("/supprimerParticipant/{participantId}")
	@ResponseBody
	public void supprimerParticipant(@PathVariable("participantId") Long participantId) {
		participantService.supprimerParticipant(participantId);

	}
	
	@GetMapping("/listParticipant")
	@ResponseBody
	public List<Participant> listParticipant() {

		return  participantService.getParticipants();
	}
}
