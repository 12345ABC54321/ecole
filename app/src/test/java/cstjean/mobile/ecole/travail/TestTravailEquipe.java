package cstjean.mobile.ecole.travail;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestTravailEquipe extends TestTravail {
    @Test
    public void testAjoutCoequipiers() {
        TravailEquipe travail = (TravailEquipe) creerTravail("TP1",
                new GregorianCalendar(2024, Calendar.SEPTEMBER, 20));

        int da1 = 123456;
        String nomCoequipier1 = "Alice";
        travail.ajouterCoequipier(da1, nomCoequipier1);
        assertEquals(nomCoequipier1, travail.getCoequipier(da1));

        int da2 = 789012;
        String nomCoequipier2 = "Bob";
        travail.ajouterCoequipier(da2, nomCoequipier2);
        assertEquals(nomCoequipier2, travail.getCoequipier(da2));

        assertEquals(nomCoequipier1, travail.getCoequipier(da1));
    }

    @Override
    protected Travail creerTravail(String nom, Calendar dateRemise) {
        return new TravailEquipe(nom, dateRemise);
    }
}
