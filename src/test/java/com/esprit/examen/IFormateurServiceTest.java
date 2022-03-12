package com.esprit.examen;

import com.esprit.examen.entities.*;
import com.esprit.examen.repositories.FormateurRepository;
import com.esprit.examen.services.FormateurService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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
        Formateur f1 = new Formateur(null,"Oussama","Tlili",Ingénieur,EXPERT,"oussama@esprit.tn","password123");;
        formateurService.addFormateur(f1);
        List<Formateur> lst2 =  formateurService.listFormateurs();
        int val2 = lst2.size();



        assertEquals(val2,val1 +1);



    }

    @Test
    @Transactional
    public void testaddFormateur() {
        Formateur form = new Formateur(null,"Oussama","Tlili",Ingénieur,EXPERT,"oussama@esprit.tn","password123");
        formateurService.addFormateur(form);
        Long id = form.getId();
        Assert.assertNotNull(id);
        Formateur savedForm = formateurService.getFormateurById(id);
        try {
            Assert.assertEquals("Oussama", savedForm.getNom());
            Assert.assertEquals("Tlili", savedForm.getPrenom());
            Assert.assertEquals(Poste.Ingénieur, savedForm.getPoste());
            Assert.assertEquals(Contrat.EXPERT, savedForm.getContrat());
            Assert.assertEquals("oussama@esprit.tn", savedForm.getEmail());
            Assert.assertEquals("password123", savedForm.getPassword());

        }finally {

            formateurService.supprimerFormateur(id);

        }
    }

    @Test
    @Transactional
    public void testmodifierFormateur() {
        Formateur form = new Formateur(null,"Oussama","Tlili",Ingénieur,EXPERT,"oussama@esprit.tn","password123");
        formateurService.addFormateur(form);
        Long id = form.getId();
        Assert.assertNotNull(id);
        Formateur savedForm = formateurService.getFormateurById(id);
        savedForm.setId(id);
        savedForm.setNom("oussama");
        savedForm.setPrenom("oussama");
        savedForm.setEmail("oussama1@esprit.tn");
        formateurService.modifierFormateur(savedForm);
        Formateur updatedForm = formateurService.getFormateurById(id);
        try {
            Assert.assertEquals("oussama", savedForm.getNom());
            Assert.assertEquals("oussama", savedForm.getPrenom());
            Assert.assertEquals(Poste.Ingénieur, savedForm.getPoste());
            Assert.assertEquals(Contrat.EXPERT, savedForm.getContrat());
            Assert.assertEquals("oussama1@esprit.tn", savedForm.getEmail());
            Assert.assertEquals("password123", savedForm.getPassword());

        } finally {
            formateurService.supprimerFormateur(id);
        }
    }

    @Test
    @Transactional
    public void testSupprimerCours() {
        Formateur form = new Formateur(null,"Oussama","Tlili",Ingénieur,EXPERT,"oussama@esprit.tn","password123");
        formateurService.addFormateur(form);
        Long id = form.getId();
        Assert.assertNotNull(id);
        List<Formateur> Form1 =  formateurService.listFormateurs();
        int firstLength1 = Form1.size();
        formateurService.supprimerFormateur(id);
        List<Formateur> Form2 =  formateurService.listFormateurs();
        int firstLength2 = Form2.size();
        Assert.assertEquals(firstLength2,firstLength1 - 1);

    }

}