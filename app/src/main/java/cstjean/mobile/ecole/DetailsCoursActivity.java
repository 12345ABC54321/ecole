package cstjean.mobile.ecole;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class DetailsCoursActivity extends AppCompatActivity implements DetailsCoursFragment.Callbacks {
    private static final String EXTRA_INDEXCOURANT = "indexcourant";
    private int indexCourant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_cours);

        indexCourant = getIntent().getIntExtra(EXTRA_INDEXCOURANT, 0);
    }

    public static Intent newIntent(Context packageContext, int indexCourant) {
        Intent intent = new Intent(packageContext, DetailsCoursActivity.class);
        intent.putExtra(EXTRA_INDEXCOURANT, indexCourant);
        return intent;
    }

    @Override
    public int getIndexCourant() {
        return indexCourant;
    }
}