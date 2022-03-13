package com.esprit.examen;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Experience;
import com.esprit.examen.entities.Participant;
import com.esprit.examen.services.ParticipantService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParticipantTest {
	@Autowired
	ParticipantService participantService;
	
	@Test
	public void testGetParticipant() {
	    List<Participant> firstList =  participantService.getParticipants();
	    int firstLength = firstList.size();
	    Participant participant = new Participant("Ghofrane","Thairi","20202020","Ghofrane@gmail.com",Experience.Debutant);
	    participantService.addParticipant(participant);
	    List<Participant> secondList =  participantService.getParticipants();
	    int secondLength = secondList.size();
	    Assert.assertEquals(secondLength,firstLength + 1);
	}

}
