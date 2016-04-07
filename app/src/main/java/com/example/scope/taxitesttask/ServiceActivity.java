package com.example.scope.taxitesttask;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by scope on 31.03.16.
 */
public class ServiceActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        toolbar = (Toolbar) findViewById(R.id.service_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Add AddPayPreference inside activity
        getFragmentManager().beginTransaction()
                .replace(R.id.service_fragment_contaner, new ServicePreference())
                .commit();
    }

    /**
     * ServicePreference fragment
     */
    public static class ServicePreference extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.service_preference);
        }
    }
}
