package cstjean.mobile.ecole.rapport;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

import junit.framework.TestCase;

import org.junit.Test;

import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.Travail;

/**
 * Classe de test pour la classe RapportTravaux.
 *
 * @author Sabrina Poulin
 */
public class TestRapportTravaux {

    /**
     * Teste la création d'instance de la classe RapportTravaux.
     */
    @Test
    public void testRapportTravaux() {
        CoursSession coursSession = new CoursSession("Philo", "101");
        Calendar dateRemise = new GregorianCalendar(2024, Calendar.SEPTEMBER, 10);

        Travail travail1 = new Travail("TP1", dateRemise);
        Travail travail2 = new Travail("TP2", dateRemise);

        coursSession.ajouterTravail(travail1);
        coursSession.ajouterTravail(travail2);

        String rapportTravaux = RapportTravaux.getRapport(coursSession);

        assertEquals(RapportTravaux.ENTETE_RAPPORT_TRAVAUX +
                "TP1 - 2024-09-10" + Rapport.SAUT_LIGNE +
                "TP2 - 2024-09-10" + Rapport.SAUT_LIGNE +
                "Total : 2" +
                RapportTravaux.PIEDPAGE_RAPPORT_TRAVAUX, rapportTravaux);
    }
}
