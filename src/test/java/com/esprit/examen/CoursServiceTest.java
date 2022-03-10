package com.esprit.examen;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.services.CoursService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoursServiceTest {

    @Autowired
    CoursService coursService;

    @Test
    public void testGetCours() {
        List<Cours> cours1 =  coursService.getCours();
        int firstLength1 = cours1.size();
        Cours cour = new Cours(null, "description", TypeCours.Informatique, "intitle");
        coursService.addCours(cour);
        List<Cours> cours2 =  coursService.getCours();
        int firstLength2 = cours2.size();
        Assert.assertEquals(firstLength2,firstLength1 + 1);
        Long id = cour.getId();
        Assert.assertNotNull(id);
        coursService.supprimerCours(id);
    }


    @Test
    @Transactional
    public void testaddCours() {
        Cours cour = new Cours(null, "description", TypeCours.Informatique, "intitle");
        coursService.addCours(cour);
        Long id = cour.getId();
        Assert.assertNotNull(id);
        Cours savedCour = coursService.getCoursById(id);
        try {
            Assert.assertEquals(TypeCours.Informatique, savedCour.getTypeCours());
            Assert.assertEquals("description", savedCour.getDescription());
            Assert.assertEquals("intitle", savedCour.getIntitule());
        }finally {
            coursService.supprimerCours(id);
        }
    }



    @Test
    @Transactional
    public void testModifierCours() {
        Cours cour = new Cours(null, "description", TypeCours.Informatique, "intitle");
        coursService.addCours(cour);
        Long id = cour.getId();
        Assert.assertNotNull(id);
        Cours savedCour = coursService.getCoursById(id);
        savedCour.setId(id);
        savedCour.setTypeCours(TypeCours.Mécanique);
        savedCour.setDescription("descriptionModif");
        savedCour.setIntitule("intitleModif");
        coursService.modifierCours(savedCour);
        Cours updatedCour = coursService.getCoursById(id);
        try {
            Assert.assertEquals("intitleModif", updatedCour.getIntitule());
            Assert.assertEquals(TypeCours.Mécanique, updatedCour.getTypeCours());
            Assert.assertEquals("descriptionModif", updatedCour.getDescription());
        } finally {
            coursService.supprimerCours(id);
        }
    }


    @Test
    @Transactional
    public void testSupprimerCours() {
        Cours cour= new Cours(null, "description", TypeCours.Informatique, "intitle");
        coursService.addCours(cour);
        Long id = cour.getId();
        Assert.assertNotNull(id);
        List<Cours> cours1 =  coursService.getCours();
        int firstLength1 = cours1.size();
        coursService.supprimerCours(id);
        List<Cours> cours2 =  coursService.getCours();
        int firstLength2 = cours2.size();
        Assert.assertEquals(firstLength2,firstLength1 - 1);
    }

 }
