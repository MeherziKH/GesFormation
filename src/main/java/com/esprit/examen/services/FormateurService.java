package com.esprit.examen.services;

import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.esprit.examen.controllers.CoursRestController;
import com.esprit.examen.controllers.FormateurRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.repositories.FormateurRepository;

@Service
public class FormateurService implements IFormateurService{

	private static final org.apache.logging.log4j.Logger l = org.apache.logging.log4j.LogManager.getLogger(FormateurRestController.class);

	@Autowired
	FormateurRepository formateurRepository;
	@Override
	public Long addFormateur(Formateur formateur) {
		l.info("In addCours() : ");
		formateurRepository.save(formateur);
		return formateur.getId();
	}

	@Override
	public Long modifierFormateur(Formateur formateur) {
		formateurRepository.save(formateur);
		return formateur.getId();
	}

	@Override
	public void supprimerFormateur(Long formateurId) {
		formateurRepository.deleteById(formateurId);
		try {
			l.info("In supprimerCours() : ");
			l.debug("Je vais lancer la suppression.");
			formateurRepository.deleteById(formateurId);
			l.debug("Je viens de lancer la suppression. ");
			l.info("Out supprimerCours() without errors.");
		}
		catch (Exception e) { l.error("Erreur dans supprimerFormateur() : " + e); }

	}
	@Override
	public Formateur getFormateurById(Long id) {
		Formateur form =  formateurRepository.getOne(id);
		return form;
	}


	@Override
	public Long nombreFormateursImpliquesDansUnCours(TypeCours typeCours) {
		//return formateurRepository.nombreFormateursImpliquesDansUnCours(typeCours);
		return null;

	}



	@Override
	public List<Formateur> listFormateurs() {

		return formateurRepository.findAll();
	}





}
