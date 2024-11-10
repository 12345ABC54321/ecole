package cstjean.mobile.ecole;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import cstjean.mobile.ecole.rapport.RapportTravaux;
import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.SingletonEcole;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailsCoursFragment} factory method to
 * create an instance of this fragment.
 */
public class DetailsCoursFragment extends Fragment {
    interface Callbacks {
        int getIndexCourant();
    }

    private TextView txtDepartement;
    private TextView txtNumero;
    private TextView txtTravaux;

    private Callbacks callbacks = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details_cours, container, false);

        txtDepartement = view.findViewById(R.id.txt_departement);
        txtNumero = view.findViewById(R.id.txt_numero);
        txtTravaux = view.findViewById(R.id.txt_travaux);

        int indexCourant = callbacks.getIndexCourant();

        CoursSession coursSession = SingletonEcole.getInstance().getCoursSession(indexCourant);

        txtDepartement.setText(coursSession.getDepartement());
        txtNumero.setText(coursSession.getNumero());
        txtTravaux.setText(RapportTravaux.getRapport(coursSession));

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        callbacks = (Callbacks) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }
}