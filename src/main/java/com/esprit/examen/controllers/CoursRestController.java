package com.esprit.examen.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.esprit.examen.entities.Cours;
import com.esprit.examen.services.ICoursService;

@RestController
public class CoursRestController {

	private static final Logger l = LogManager.getLogger(CoursRestController.class);

@Autowired
ICoursService coursService;

@PostMapping("/ajouterCours")
@ResponseBody
public Cours ajouterCours(@RequestBody Cours cours) {
	l.info("In ajouterCours() : ");
	coursService.addCours(cours);
	return cours;
}

@PutMapping("/modifierCours")
@ResponseBody
public Cours modifierCours(@RequestBody Cours cours) {
	coursService.addCours(cours);
	return cours;
}

@DeleteMapping("/supprimerCours/{coursId}")
@ResponseBody
public void supprimerCours(@PathVariable("coursId") Long coursId) {
	try {
		l.info("In supprimerCours() : ");
		l.debug("Je vais lancer la suppression.");
		coursService.supprimerCours(coursId);
		l.debug("Je viens de lancer la suppression. ");
		l.info("Out supprimerCours() without errors.");
	}
	catch (Exception e) { l.error("Erreur dans supprimerCours() : " + e); }

}

@GetMapping("/listeCours")
@ResponseBody
public List<Cours> listeCours() {

	return  coursService.getCours();
}

@PutMapping("/affecterCoursASession/{coursId}/{sessionId}")
@ResponseBody
public String affecterFormateurASession(@PathVariable("coursId")  Long coursId, @PathVariable("sessionId") Long sessionId) {
	coursService.affecterCoursASession(coursId, sessionId);
	return "cours affecté correctement";
}

}
