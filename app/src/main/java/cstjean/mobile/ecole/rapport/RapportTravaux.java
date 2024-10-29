package cstjean.mobile.ecole.rapport;

import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.Travail;

import java.text.SimpleDateFormat;
/**
 * Représente un rapport.
 *
 * @author Sabrina Poulin
 */
public class RapportTravaux extends Rapport {

    /**
     * Entete d'un rapport de travaux.
     */
    static final String ENTETE_RAPPORT_TRAVAUX = "---------- TRAVAUX ----------" + SAUT_LIGNE;

    /**
     * Pied de page d'un rapport de travaux.
     */
    static final String PIEDPAGE_RAPPORT_TRAVAUX = SAUT_LIGNE + "--------------------";

    /**
     * Retourne le rapport.
     *
     * @param coursSession Le cours sur lequel se base le rapport.
     *
     * @return Le rapport.
     */
    public static String getRapport(CoursSession coursSession) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder builder = new StringBuilder();
        builder.append(ENTETE_RAPPORT_TRAVAUX);

        for (int i = 0; i < coursSession.getNombreTravaux(); i++) {
            Travail travail = coursSession.getTravail(i);
            builder.append(travail.getNom())
                    .append(" - ")
                    .append(formatDate.format(travail.getDateRemise().getTime()))
                    .append(SAUT_LIGNE);
        }

        builder.append("Total : ")
                .append(coursSession.getNombreTravaux())
                .append(PIEDPAGE_RAPPORT_TRAVAUX);

        return builder.toString();
    }
}
