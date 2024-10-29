package cstjean.mobile.ecole.rapport;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cstjean.mobile.ecole.travail.CoursSession;

public class TestRapportCours {
    @Test
    public void testRapport() {
        RapportCours rapport = new RapportCours();
        rapport.ajouter(new CoursSession("FRANCAIS", "101"));
        rapport.ajouter(new CoursSession("MATHS", "301"));
        rapport.ajouter(new CoursSession("PHILO", "301"));
        rapport.ajouter(new CoursSession("MATHS", "201"));
        rapport.ajouter(new CoursSession("PHILO", "201"));

        assertEquals("FRANCAIS 101" + Rapport.SAUT_LIGNE +
                "MATHS 201" + Rapport.SAUT_LIGNE +
                "MATHS 301" + Rapport.SAUT_LIGNE +
                "PHILO 201" + Rapport.SAUT_LIGNE +
                "PHILO 301" + Rapport.SAUT_LIGNE, rapport.getRapportCours());
    }
}
