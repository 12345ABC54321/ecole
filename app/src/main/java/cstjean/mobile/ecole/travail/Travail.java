package cstjean.mobile.ecole.travail;

import androidx.annotation.NonNull;

import java.util.Calendar;
import java.util.Objects;

/**
 * Représente un travail a faire.
 *
 * @author Sabrina Poulin
 */
public class Travail implements Cloneable {
    /**
     * Le nom du travail.
     */
    private final String nom;
    private Calendar dateRemise;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Travail travail = (Travail) o;
        return Objects.equals(nom, travail.nom) && Objects.equals(dateRemise, travail.dateRemise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, dateRemise);
    }

    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Travail clone = (Travail) super.clone();
        clone.dateRemise = (Calendar) dateRemise.clone();
        return clone;

    }
}