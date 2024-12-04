package com.example.calculadora_financiera;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SubMenuAmor extends AppCompatActivity {
    private String calculationType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submenuamor);

        calculationType = getIntent().getStringExtra("CALCULATION_TYPE");
        Log.d("SubMenuAmor", "Calculation Type: " + calculationType);
        setupSubMenuButtons();
    }

    private void setupSubMenuButtons() {
        Button btnIntereses = findViewById(R.id.btnIntereses);
        Button btnRenta = findViewById(R.id.btnRenta);
        Button btnAmortizacion = findViewById(R.id.btnAmortizacion);
        Button btnNuevoSaldo = findViewById(R.id.btnNuevoSaldo);

        btnIntereses.setOnClickListener(v -> navigateToCalculator("intereses"));
        btnRenta.setOnClickListener(v -> navigateToCalculator("renta"));
        btnAmortizacion.setOnClickListener(v -> navigateToCalculator("amortizacion"));
        btnNuevoSaldo.setOnClickListener(v -> navigateToCalculator("nuevo_saldo"));
    }

    private void navigateToCalculator(String variable) {
        Intent intent = null;
        Log.d("SubMenuAmor", "Navigating with Calculation Type: " + calculationType + ", Variable: " + variable);

        if (calculationType != null) {
            switch (variable) {
                case "intereses":
                    intent = new Intent(this, Intereses.class);
                    break;
                case "renta":
                    intent = new Intent(this, RentaAmor.class);
                    break;
                case "amortizacion":
                    intent = new Intent(this, Amortizacion.class);
                    break;
                case "nuevo_saldo":
                    intent = new Intent(this, NuevoSaldo.class);
                    break;
                default:
                    Log.d("SubMenuAmor", "Invalid variable: " + variable);
                    return;
            }

            if (intent != null) {
                Log.d("SubMenuAmor", "Starting activity for variable: " + variable);
                startActivity(intent);
            } else {
                Log.d("SubMenuAmor", "Intent is null for calculationType: " + calculationType + ", Variable: " + variable);
            }
        } else {
            Log.d("SubMenuAmor", "CalculationType is null");
        }
    }
}
