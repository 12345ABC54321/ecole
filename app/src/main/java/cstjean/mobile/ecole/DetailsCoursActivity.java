package cstjean.mobile.ecole;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import cstjean.mobile.ecole.rapport.RapportTravaux;
import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.SingletonEcole;


public class DetailsCoursActivity extends AppCompatActivity {
    private static final String EXTRA_INDEXCOURANT = "indexcourant";

    private TextView txtDepartement;
    private TextView txtNumero;
    private TextView txtTravaux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_cours);

        txtDepartement = findViewById(R.id.txt_departement);
        txtNumero = findViewById(R.id.txt_numero);
        txtTravaux = findViewById(R.id.txt_travaux);

        int indexCourant = getIntent().getIntExtra(EXTRA_INDEXCOURANT, 0);

        CoursSession coursSession = SingletonEcole.getInstance().getCoursSession(indexCourant);

        txtDepartement.setText(coursSession.getDepartement());
        txtNumero.setText(coursSession.getNumero());
        txtTravaux.setText(RapportTravaux.getRapport(coursSession));
    }

    public static Intent newIntent(Context packageContext, int indexCourant) {
        Intent intent = new Intent(packageContext, DetailsCoursActivity.class);
        intent.putExtra(EXTRA_INDEXCOURANT, indexCourant);
        return intent;
    }
}