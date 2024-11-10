package cstjean.mobile.ecole;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class AjoutCoursActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_cours);
    }

    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, AjoutCoursActivity.class);
        return intent;
    }
}