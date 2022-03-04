package com.esprit.examen;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.services.ICoursService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoursServiceTest {
    ICoursService coursService;

    @Test(timeout = 5000)
    public void testSupprimerCours() {
    }
}
