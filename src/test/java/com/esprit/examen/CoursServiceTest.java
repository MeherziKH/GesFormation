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

    @Test
    public void testSupprimerCours() {
        Cours cours = new Cours(null, "description", TypeCours.Informatique, "intitle");
        System.out.print(cours);
        coursService.addCours(cours);
        Long id = cours.getId();
        System.out.print(id);
        Assert.assertNotNull(id);
        System.out.println("id : "+ id);
        Cours savedCours = coursService.getCoursById(id);
        try {
            Assert.assertEquals("description", savedCours.getDescription());
            Assert.assertEquals("INFORMATIQUE", savedCours.getTypeCours());
            Assert.assertEquals("intitle", savedCours.getIntitule());

        }
        finally {
            System.out.println("Delete last insert .....");
            coursService.supprimerCours(id);
        }
    }




 }
