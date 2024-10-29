package cstjean.mobile.ecole.travail;

import static org.junit.Assert.assertEquals;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Classe de test pour la classe Travail.
 *
 * @author Sabrina Poulin
 */
public class TestTravail {
    /**
     * Teste la création d'instance de la classe Travail et vérifie que le nom est correctement assigné.
     */
    @Test
    public void testCreer() {
        Calendar dateRemise = new GregorianCalendar(2024,Calendar.SEPTEMBER,10);

        String nomTravail1 = "TP1";
        Travail travail1 = creerTravail(nomTravail1, dateRemise);
        assertEquals(nomTravail1, travail1.getNom());
        assertEquals(dateRemise, travail1.getDateRemise());

        String nomTravail2 = "TP2";
        Travail travail2 = creerTravail(nomTravail2, dateRemise);
        assertEquals(nomTravail2, travail2.getNom());
        assertEquals(dateRemise, travail2.getDateRemise());
    }

    protected Travail creerTravail(String nom, Calendar dateRemise) {
        return new Travail(nom, dateRemise);
    }
}