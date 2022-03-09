package com.esprit.examen;

import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.Poste;
import com.esprit.examen.repositories.FormateurRepository;
import com.esprit.examen.services.FormateurService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.esprit.examen.entities.Contrat.EXPERT;
import static com.esprit.examen.entities.Poste.Ingénieur;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IFormateurServiceTest {
    @Autowired
    FormateurService formateurService;

    @Test
    public void testListFormateur() {

        List<Formateur> lst1 =  formateurService.listFormateurs();
        int val1 = lst1.size();
        Formateur f1 = new Formateur(11L,"khaled","naili",Ingénieur,EXPERT,"khaled.naili@esprit.tn","password123");
        formateurService.addFormateur(f1);
        List<Formateur> lst2 =  formateurService.listFormateurs();
        int val2 = lst2.size();



        assertEquals(val2,val1 +1);



    }

}