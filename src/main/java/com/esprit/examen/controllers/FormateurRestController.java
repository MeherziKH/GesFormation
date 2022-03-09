package com.esprit.examen.controllers;

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
import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.services.IFormateurService;

import java.util.List;


@RestController
public class FormateurRestController {
	private static final Logger l = LogManager.getLogger(FormateurRestController.class);

	@Autowired
	IFormateurService formateurService;

	@PostMapping("/ajouterFormateur")
	@ResponseBody
	public Formateur ajouterFormateur(@RequestBody Formateur formateur) {
		formateurService.addFormateur(formateur);
		return formateur;
	}
	@GetMapping("/listeFormateur")
	@ResponseBody
	public List<Formateur> listeFormateurs() {

		return  formateurService.listFormateurs();
	}

	@PutMapping("/modifierFormateur")
	@ResponseBody
	public Formateur modifierFormateur(@RequestBody Formateur formateur) {
		formateurService.addFormateur(formateur);
		return formateur;
	}

	@DeleteMapping("/supprimerFormateur/{formateurId}")
	@ResponseBody
	public void supprimerFormateur(@PathVariable("formateurId") Long formateurId) {
		try {
			l.info("Supprimer formateur : ");
			l.debug("Je vais lancer la suppr.");
			formateurService.supprimerFormateur(formateurId);
			l.debug("Je viens de lancer la suppr 1 " );
			l.debug("Je viens de finir la suppr X.");

			l.info("Out getAllFormteur() without errors.");
		}
		catch (Exception e) { l.error("Erreur dans getAllFormateur() : " + e); }

	}

	@GetMapping("/nombreFormateursImpliquesDansUnCours/{typeCours}")
	@ResponseBody
	public Long nombreFormateursImpliquesDansUnCours(@PathVariable("typeCours") TypeCours typeCours) {
		Long nombreFormateurs=formateurService.nombreFormateursImpliquesDansUnCours(typeCours);
		return nombreFormateurs;
	}
}
