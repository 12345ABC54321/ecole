package cstjean.mobile.ecole.travail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public class TestSingletonEcole {
    SingletonEcole singleton1 = SingletonEcole.getInstance();

    @Before
    public void setUp() {
        singleton1.reinitialiserListeCours();
    }

    @Test
    public void testInstance() {
        SingletonEcole singleton1 = SingletonEcole.getInstance();
        SingletonEcole singleton2 = SingletonEcole.getInstance();
        assertSame(singleton1, singleton2);
        assertEquals(4, singleton1.getNbCoursSession());
        CoursSession coursSession = singleton1.getCoursSession(0);
        assertEquals("Philo 101", coursSession.getDepartementNumero());
    }

    @Test
    public void testAjoutCours() {
        CoursSession cours = new CoursSession("Prog", "101");
        singleton1.ajouterCoursSession(cours);
        assertEquals(cours, singleton1.getCoursSession(singleton1.getNbCoursSession() - 1));
    }
}