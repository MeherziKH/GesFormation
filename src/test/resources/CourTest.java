package com.esprit.examen;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.services.ICoursService;

public class CourTest {
	@Autowired
	ICoursService coursService;
	
	@Test
	public void testGetCours() {
	    List<Cours> cours1 =  coursService.getCours();
	    int firstLength1 = cours1.size();
	    Cours cour = new Cours();
	    cour.setIntitule("test");
	    cour.setDescription("test");
	    cour.setSessions(null);
	    cour.setTypeCours(null);
	    coursService.addCours(cour);
	    List<Cours> cours2 =  coursService.getCours();
	    int firstLength2 = cours2.size();

	    Assert.assertEquals(firstLength2,firstLength1 + 1);
	}
}
