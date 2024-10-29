package cstjean.mobile.ecole;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.SingletonEcole;

public class AjoutCoursActivity extends AppCompatActivity {

    private EditText txtDepartement;
    private EditText txtNoCours;
    Button btnAjouter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_cours);

        txtDepartement = findViewById(R.id.input_departement);
        txtNoCours = findViewById(R.id.input_numero);
        btnAjouter = findViewById(R.id.btn_ajouter);

        btnAjouter.setOnClickListener(v -> {
            String strDepartement = txtDepartement.getText().toString();
            String strNoCours = txtNoCours.getText().toString();
            CoursSession cours = new CoursSession(strDepartement, strNoCours);
            SingletonEcole.getInstance().ajouterCoursSession(cours);
            finish();
        });
    }

    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, AjoutCoursActivity.class);
        return intent;
    }
}