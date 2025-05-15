package com.example.a5am_oroscopo;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class RisultatoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risultato);

        LinearLayout resultLayout = findViewById(R.id.resultLayout);
        TextView textViewResult = findViewById(R.id.textViewResult);
        ImageView imageViewZodiac = findViewById(R.id.imageViewZodiac);

        // Recupera i dati dall'Intent
        String name = getIntent().getStringExtra("name");
        String date = getIntent().getStringExtra("date");
        String gender = getIntent().getStringExtra("gender");

        // Imposta lo sfondo in base al genere
        if (gender.equals("Maschio")) {
            resultLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_bright));
        } else {
            resultLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light)); // Rosa
        }

        // Calcola l'età
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(date, formatter);
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(birthDate, currentDate).getYears();

        // Determina il segno zodiacale
        String zodiacSign = getZodiacSign(birthDate.getDayOfMonth(), birthDate.getMonthValue());

        // Imposta l'immagine del segno zodiacale
        int zodiacImageResId = getZodiacImage(zodiacSign);
        imageViewZodiac.setImageResource(zodiacImageResId);

        // Mostra il risultato
        textViewResult.setText(String.format("Ciao %s!\n\nHai %d anni.\n\nIl tuo segno zodiacale è: %s", name, age, zodiacSign));
    }

    private String getZodiacSign(int day, int month) {
        if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) return "Ariete";
        if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) return "Toro";
        if ((month == 5 && day >= 21) || (month == 6 && day <= 20)) return "Gemelli";
        if ((month == 6 && day >= 21) || (month == 7 && day <= 22)) return "Cancro";
        if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) return "Leone";
        if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) return "Vergine";
        if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) return "Bilancia";
        if ((month == 10 && day >= 23) || (month == 11 && day <= 21)) return "Scorpione";
        if ((month == 11 && day >= 22) || (month == 12 && day <= 21)) return "Sagittario";
        if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) return "Capricorno";
        if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) return "Acquario";
        return "Pesci";
    }

    private int getZodiacImage(String zodiacSign) {
        switch (zodiacSign) {
            case "Ariete": return R.drawable.ariete;
            case "Toro": return R.drawable.toro;
            case "Gemelli": return R.drawable.gemelli;
            case "Cancro": return R.drawable.cancro;
            case "Leone": return R.drawable.leone;
            case "Vergine": return R.drawable.vergine;
            case "Bilancia": return R.drawable.bilancia;
            case "Scorpione": return R.drawable.scorpione;
            case "Sagittario": return R.drawable.sagittario;
            case "Capricorno": return R.drawable.capricorno;
            case "Acquario": return R.drawable.acquario;
            case "Pesci": return R.drawable.pesci;
            default: return R.drawable.ariete; // Fallback
        }
    }
}