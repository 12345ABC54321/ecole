package cstjean.mobile.ecole;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class ListeCoursActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_cours);

        Log.d("ProjetEcole", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ProjetEcole", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ProjetEcole", "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ProjetEcole", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ProjetEcole", "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ProjetEcole", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ProjetEcole", "onResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("ProjetEcole", "onSaveInstanceState");
    }
}