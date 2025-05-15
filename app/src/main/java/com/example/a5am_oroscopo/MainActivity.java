package com.example.a5am_oroscopo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private DatePicker datePicker;
    private Spinner spinnerGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        datePicker = findViewById(R.id.datePicker);
        spinnerGender = findViewById(R.id.spinnerGender);
        Button buttonCalculate = findViewById(R.id.buttonCalculate);

        // Configura lo Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.gender_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(adapter);

        buttonCalculate.setOnClickListener(v -> {
            String name = editTextName.getText().toString().trim();
            String gender = spinnerGender.getSelectedItem().toString();

            // Validazione nome
            if (name.isEmpty()) {
                Toast.makeText(this, "Inserisci il nome", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validazione genere
            if (gender.equals("Seleziona genere")) {
                Toast.makeText(this, "Seleziona un genere", Toast.LENGTH_SHORT).show();
                return;
            }

            // Recupera la data dal DatePicker
            int day = datePicker.getDayOfMonth();
            int month = datePicker.getMonth() + 1; // DatePicker restituisce mese da 0-11
            int year = datePicker.getYear();
            String date = String.format("%02d/%02d/%04d", day, month, year);

            // Passa i dati alla ResultActivity
            Intent intent = new Intent(MainActivity.this, RisultatoActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("date", date);
            intent.putExtra("gender", gender);
            startActivity(intent);
        });
    }
}