package cstjean.mobile.ecole.travail;

public class NumeroCoursUtil {
    public static boolean estNumeroCoursValide(String numeroCours) {
        String regex = "^\\d[\\d\\D]\\d$";
        return numeroCours.matches(regex);
    }
}