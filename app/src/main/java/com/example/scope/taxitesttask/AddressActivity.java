package com.example.scope.taxitesttask;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class AddressActivity extends AppCompatActivity {

    public static final String APP_PREFERENCES = "address";
    public static final String PREFERENCES_APARTMENT = "apartmentEdit";
    public static final String PREFERENCES_PORCH = "porch";
    public static final String PREFERENCES_DESCRIPTION = "description";

    private EditText apartmentEdit;
    private EditText porchEdit;
    private EditText descriptionEdit;
    private SharedPreferences shared;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        porchEdit = (EditText) findViewById(R.id.porch_edit);
        apartmentEdit = (EditText) findViewById(R.id.apartment_edit);
        descriptionEdit = (EditText) findViewById(R.id.description_edit);

        toolbar = (Toolbar) findViewById(R.id.address_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                finish();
            }
        });

        shared = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        getData();
    }


    @Override
    protected void onPause() {
        saveData();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }

    @Override
    public void onBackPressed() {
        saveData();
        super.onBackPressed();
    }


    @Override
    protected void onStop() {
        saveData();
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getData();
    }

    // Save date this Activity
    public void saveData() {
        SharedPreferences.Editor editor = shared.edit();

        String porch = porchEdit.getText().toString();
        String apartment = apartmentEdit.getText().toString();
        String description = descriptionEdit.getText().toString();

        editor.putString(PREFERENCES_PORCH, porch);
        editor.putString(PREFERENCES_APARTMENT, apartment);
        editor.putString(PREFERENCES_DESCRIPTION, description);
        editor.apply();
    }

    // Get saved date this Activity
    public void getData() {
        if (shared.contains(PREFERENCES_PORCH)) {
            porchEdit.setText(shared.getString(PREFERENCES_PORCH, ""));
        }
        if (shared.contains(PREFERENCES_APARTMENT)) {
            apartmentEdit.setText(shared.getString(PREFERENCES_APARTMENT, ""));
        }
        if (shared.contains(PREFERENCES_DESCRIPTION)) {
            descriptionEdit.setText(shared.getString(PREFERENCES_DESCRIPTION, ""));
        }
    }
}


