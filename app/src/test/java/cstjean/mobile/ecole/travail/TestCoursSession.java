package cstjean.mobile.ecole.travail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Before;
import org.junit.Test;


public class TestCoursSession {
    private CoursSession coursSession;

    @Before
    public void setUp() {
        coursSession = new CoursSession("Philo", "101");
    }

    @Test
    public void testCreer() {
        assertEquals("Philo", coursSession.getDepartement());
        assertEquals("101", coursSession.getNumero());
        assertEquals("Philo 101", coursSession.getDepartementNumero());
        assertEquals(0, coursSession.getNombreTravaux());
    }

    @Test
    public void testAjoutTravail() {
        Calendar dateRemise = new GregorianCalendar(2024, Calendar.SEPTEMBER, 10);
        Travail travail1 = new Travail("TP1", dateRemise);
        coursSession.ajouterTravail(travail1);
        assertEquals(1, coursSession.getNombreTravaux());
        assertEquals(travail1, coursSession.getTravail(0));

        Travail travail2 = new Travail("TP2", dateRemise);
        coursSession.ajouterTravail(travail2);
        assertEquals(2, coursSession.getNombreTravaux());
        assertEquals(travail1, coursSession.getTravail(0));
        assertEquals(travail2, coursSession.getTravail(1));
    }

    /**
     * Teste le compteur du nombre de rapport generes de la classe RapportTravaux.
     */
    @Test
    public void testCompteur() {
        CoursSession.resetCompteur();
        assertEquals(0, CoursSession.getCompteur());

        new CoursSession("Philo", "101");
        assertEquals(1, CoursSession.getCompteur());

        new CoursSession("Philo", "101");
        assertEquals(2, CoursSession.getCompteur());

        new CoursSession("Philo", "101");
        assertEquals(3, CoursSession.getCompteur());

        CoursSession.resetCompteur();
        assertEquals(0, CoursSession.getCompteur());
    }

    @Test
    public void testCompare() {
        assertEquals(0, coursSession.compareTo(new CoursSession("Philo", "101")));
        assertTrue(coursSession.compareTo(new CoursSession("Philo", "201")) < 0);
        assertTrue(coursSession.compareTo(new CoursSession("Math", "101")) > 0);
    }

    @Test
    public void testURL() throws MalformedURLException {
        final String url = "https://www.cstjean.qc.ca/philo101";
        coursSession.setUrl(url);
        assertEquals(url, coursSession.getUrl().toString());
    }

    @Test(expected = MalformedURLException.class)
    public void testUrlInvalidejUnit4() throws MalformedURLException {
        final String donnee = "PASVALIDE";
        coursSession.setUrl(donnee);
    }

    @Test
    public void testUrlInvalidejUnit3() {
        final String donnee = "PASVALIDE";
        try {
            coursSession.setUrl(donnee);
            fail("La donnée devrait être invalide");
        } catch (MalformedURLException e) {
            // On ne fait rien dans un test
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNumeroCoursInvalide() {
        new CoursSession("Philo", "AAA");
    }
}