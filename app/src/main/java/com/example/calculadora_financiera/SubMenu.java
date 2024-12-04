package com.example.calculadora_financiera;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculadora_financiera.R;

public class SubMenu extends AppCompatActivity {
    private String calculationType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submenu);

        calculationType = getIntent().getStringExtra("CALCULATION_TYPE");
        Log.d("SubMenu", "Calculation Type: " + calculationType);
        setupSubMenuButtons();
    }

    private void setupSubMenuButtons() {
        Button btnMonto = findViewById(R.id.btnMonto);
        Button btnCapital = findViewById(R.id.btnCapital);
        Button btnTasaInteres = findViewById(R.id.btnTasaInteres);
        Button btnPlazo = findViewById(R.id.btnPlazo);

        btnMonto.setOnClickListener(v -> navigateToCalculator("monto"));
        btnCapital.setOnClickListener(v -> navigateToCalculator("capital"));
        btnTasaInteres.setOnClickListener(v -> navigateToCalculator("tasa"));
        btnPlazo.setOnClickListener(v -> navigateToCalculator("plazo"));
    }

    private void navigateToCalculator(String variable) {
        Intent intent = null;
        Log.d("SubMenu", "Navigating with Calculation Type: " + calculationType + ", Variable: " + variable);

        if (calculationType != null) {
            switch (calculationType) {
                case "simple_interest":
                    switch (variable) {
                        case "monto":
                            intent = new Intent(this, Monto.class);
                            break;
                        case "capital":
                            intent = new Intent(this, Capital.class);
                            break;
                        case "tasa":
                            intent = new Intent(this, TasaInteres.class);
                            break;
                        case "plazo":
                            intent = new Intent(this, Plazos.class);
                            break;
                        default:
                            Log.d("SubMenu", "Invalid variable: " + variable);
                            return;
                    }
                    break;
                default:
                    Log.d("SubMenu", "Invalid calculationType: " + calculationType);
                    return;
            }

            if (intent != null) {
                Log.d("SubMenu", "Starting activity for variable: " + variable);
                startActivity(intent);
            } else {
                Log.d("SubMenu", "Intent is null for calculationType: " + calculationType + ", Variable: " + variable);
            }
        } else {
            Log.d("SubMenu", "CalculationType is null");
        }
    }
}
