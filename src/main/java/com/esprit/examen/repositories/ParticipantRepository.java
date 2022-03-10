package com.esprit.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.examen.entities.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

}
