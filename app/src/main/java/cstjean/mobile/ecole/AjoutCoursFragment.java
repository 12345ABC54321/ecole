package cstjean.mobile.ecole;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.SingletonEcole;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AjoutCoursFragment} factory method to
 * create an instance of this fragment.
 */
public class AjoutCoursFragment extends Fragment {
    private EditText txtDepartement;
    private EditText txtNoCours;
    Button btnAjouter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ajout_cours, container, false);
        // Charger les controles a partir de l'interface
        txtDepartement = view.findViewById(R.id.input_departement);
        txtNoCours = view.findViewById(R.id.input_numero);
        btnAjouter = view.findViewById(R.id.btn_ajouter);

        btnAjouter.setOnClickListener(v -> {
            String strDepartement = txtDepartement.getText().toString();
            String strNoCours = txtNoCours.getText().toString();
            CoursSession cours = new CoursSession(strDepartement, strNoCours);
            SingletonEcole.getInstance().ajouterCoursSession(cours);
            getActivity().finish();
        });
        return view;
    }
}