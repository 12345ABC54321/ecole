package cstjean.mobile.ecole.travail;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CoursSession implements Comparable<CoursSession> {
    private final String departement;
    private final String numero;
    private URL url;
    private final List<Travail> travaux = new ArrayList<Travail>();
    public static int compteur = 0;

    public CoursSession(String departement, String numero) throws IllegalArgumentException {
        this.departement = departement;
        if (!NumeroCoursUtil.estNumeroCoursValide(numero)) {
            throw new IllegalArgumentException();
        }
        this.numero = numero;
        incrementerCompteur();
    }

    public String getDepartement() {
        return departement;
    }

    public String getNumero() {
        return numero;
    }

    public String getDepartementNumero() {
        return departement + " " + numero;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(String url) throws MalformedURLException {
        this.url = new URL(url);
    }

    public void ajouterTravail(Travail travail) {
        travaux.add(travail);
    }

    public int getNombreTravaux() {
        return travaux.size();
    }

    public Travail getTravail(int index) {
        return travaux.get(index);
    }

    private static void incrementerCompteur() {
        compteur++;
    }

    static int getCompteur() {
        return compteur;
    }

    static void resetCompteur() {
        compteur = 0;
    }

    @Override
    public int compareTo(CoursSession o) {
        int compareDepartement = getDepartement().compareTo(o.getDepartement());

        if (compareDepartement != 0) {
            return compareDepartement;
        }

        return getNumero().compareTo(o.getNumero());
    }
}
