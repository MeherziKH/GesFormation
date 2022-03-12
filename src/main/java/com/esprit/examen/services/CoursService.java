package com.esprit.examen.services;

import java.util.List;
import java.util.Set;

import com.esprit.examen.controllers.CoursRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.Session;
import com.esprit.examen.repositories.CoursRepository;
import com.esprit.examen.repositories.SessionRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class CoursService implements ICoursService {

	private static final Logger l = LogManager.getLogger(CoursRestController.class);

	@Autowired
	CoursRepository coursRepository;

	@Autowired
	SessionRepository sessionRepository;


	@Override
	public Long addCours(Cours cours) {
		l.info("In addCours() : ");
		coursRepository.save(cours);
		return cours.getId();
	}

	@Override
	public Long modifierCours(Cours cours) {
		coursRepository.save(cours);
		return cours.getId();
	}

	@Override
	public void supprimerCours(Long coursId) {
		try {
			l.info("In supprimerCours() : ");
			l.debug("Je vais lancer la suppression.");
			coursRepository.deleteById(coursId);
			l.debug("Je viens de lancer la suppression. ");
			l.info("Out supprimerCours() without errors.");
		}
		catch (Exception e) { l.error("Erreur dans supprimerCours() : " + e); }
	}

	@Override
	public List<Cours> getCours() {
		List<Cours> cours =   coursRepository.findAll();
		return cours;
	}

	@Override
	public Cours getCoursById(Long id) {
		Cours cour =  coursRepository.getOne(id);
		return cour;
	}


	@Override
	public void affecterCoursASession(Long coursId, Long sessionId)
	{
		Session session =  sessionRepository.getOne(coursId);
		List<Cours> cours = coursRepository.findAll();
		//session.setCours(cours);
        
	}

}
