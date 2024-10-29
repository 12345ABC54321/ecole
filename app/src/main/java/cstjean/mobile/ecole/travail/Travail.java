package cstjean.mobile.ecole.travail;

import java.util.Calendar;

/**
 * Représente un travail a faire.
 *
 * @author Sabrina Poulin
 */
public class Travail {
    /**
     * Le nom du travail.
     */
    private final String nom;
    private final Calendar dateRemise;

    /**
     * Constructeur pour créer une instance de Travail.
     *
     * @param nom Le nom du travail.
     */
    public Travail(String nom, Calendar dateRemise) {
        this.nom = nom;
        this.dateRemise = dateRemise;
    }

    /**
     * Retourne le nom du travail.
     *
     * @return Le nom du travail.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne la date de remise du travail.
     *
     * @return La date de remise du travail.
     */
    public Calendar getDateRemise() {
        return dateRemise;
    }
}