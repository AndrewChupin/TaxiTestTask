package com.example.scope.taxitesttask;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by scope on 31.03.16.
 */
public class PayActivity extends AppCompatActivity {

    private Toolbar toolbar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        toolbar = (Toolbar) findViewById(R.id.pay_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Add ChoicePayPreference inside activity
        getFragmentManager().beginTransaction()
                .replace(R.id.choice_pay_container, new ChoicePayPreference())
                .commit();

        // Add AddPayPreference inside activity
        getFragmentManager().beginTransaction()
                .replace(R.id.add_pay_container, new AddPayPreference())
                .commit();
    }

    /**
     * ChoicePayPreference fragment
     */
    public static class ChoicePayPreference extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.choice_pay_preference);
        }
    }

    /**
     * AddPayPreference fragment
     */
    public static class AddPayPreference extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.add_pay_preference);
        }
    }
}
