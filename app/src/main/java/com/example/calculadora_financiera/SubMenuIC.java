package com.example.calculadora_financiera;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SubMenuIC extends AppCompatActivity {
    private String calculationType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submenuic);

        calculationType = getIntent().getStringExtra("CALCULATION_TYPE");
        Log.d("SubMenuIC", "Calculation Type: " + calculationType);
        setupSubMenuButtons();
        setupBackButton();
    }

    private void setupSubMenuButtons() {
        Button btnMonto = findViewById(R.id.btnMonto);
        Button btnCapital = findViewById(R.id.btnCapital);
        Button btnPeriodosCapitalizacion = findViewById(R.id.btnPeriodosCapitalizacion);
        Button btnTasaInteresCapitalizable = findViewById(R.id.btnTasaInteresCapitalizable);

        btnMonto.setOnClickListener(v -> navigateToCalculator("monto"));
        btnCapital.setOnClickListener(v -> navigateToCalculator("capital"));
        btnPeriodosCapitalizacion.setOnClickListener(v -> navigateToCalculator("periodos_capitalizacion"));
        btnTasaInteresCapitalizable.setOnClickListener(v -> navigateToCalculator("tasa_interes_capitalizable"));
    }

    private void setupBackButton() {
        Button btnRegresar = findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(v -> onBackPressed());
    }

    private void navigateToCalculator(String variable) {
        Intent intent = null;
        Log.d("SubMenuIC", "Navigating with Calculation Type: " + calculationType + ", Variable: " + variable);

        if (calculationType != null) {
            switch (variable) {
                case "monto":
                    intent = new Intent(this, MontoIC.class);
                    break;
                case "capital":
                    intent = new Intent(this, CapitalIC.class);
                    break;
                case "periodos_capitalizacion":
                    intent = new Intent(this, PeriodosDeCapitalizacion.class);
                    break;
                case "tasa_interes_capitalizable":
                    intent = new Intent(this, TasaDeInteresCapitalizable.class);
                    break;
                default:
                    Log.d("SubMenuIC", "Invalid variable: " + variable);
                    return;
            }

            if (intent != null) {
                Log.d("SubMenuIC", "Starting activity for variable: " + variable);
                startActivity(intent);
            } else {
                Log.d("SubMenuIC", "Intent is null for calculationType: " + calculationType + ", Variable: " + variable);
            }
        } else {
            Log.d("SubMenuIC", "CalculationType is null");
        }
    }
}
