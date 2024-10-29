package cstjean.mobile.ecole;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import cstjean.mobile.ecole.travail.SingletonEcole;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListeCoursFragment} factory method to
 * create an instance of this fragment.
 */
public class ListeCoursFragment extends Fragment {
    private ImageButton btnSuivant;
    private ImageButton btnPrecedent;
    private TextView txtDepartement;
    private ImageButton btnVoir;
    private ImageButton btnAjout;
    private int indexCourant = 0;
    private static final String KEY_INDEXCOURANT = "indexcourant";

    private final SingletonEcole singletonEcole = SingletonEcole.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            indexCourant = savedInstanceState.getInt(KEY_INDEXCOURANT, 0);
        }
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_liste_cours, container, false);
        btnPrecedent = view.findViewById(R.id.btn_precedent);
        btnSuivant = view.findViewById(R.id.btn_suivant);
        txtDepartement = view.findViewById(R.id.txt_departement);
        btnVoir = view.findViewById(R.id.btn_voir);
        btnAjout = view.findViewById(R.id.btn_ajout);

        btnPrecedent.setOnClickListener(v -> {
            indexCourant--;
            updateDepartement();
        });

        btnSuivant.setOnClickListener(v -> {
            indexCourant++;
            updateDepartement();
        });

        btnVoir.setOnClickListener(v -> {
            Intent intent = DetailsCoursActivity.newIntent(getActivity(), indexCourant);
            startActivity(intent);
        });

        btnAjout.setOnClickListener(v -> {
            Intent intent = AjoutCoursActivity.newIntent(getActivity());
            startActivity(intent);
        });

        updateDepartement();

        return view;
    }

    private void updateDepartement() {
        String departement = singletonEcole.getCoursSession(indexCourant).getDepartementNumero();
        txtDepartement.setText(departement);

        btnSuivant.setEnabled(indexCourant < singletonEcole.getNbCoursSession() - 1);
        btnPrecedent.setEnabled(indexCourant > 0);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("ProjetEcole", "onSaveInstanceState");
        outState.putInt(KEY_INDEXCOURANT, indexCourant);
    }

    @Override
    public void onResume() {
        super.onResume();
        updateDepartement();
        Log.d("ProjetEcole", "onResume");
    }
}