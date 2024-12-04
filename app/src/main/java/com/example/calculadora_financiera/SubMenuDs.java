package com.example.calculadora_financiera;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SubMenuDs extends AppCompatActivity {
    private String calculationType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submenuds);

        calculationType = getIntent().getStringExtra("CALCULATION_TYPE");
        Log.d("SubMenuDS", "Calculation Type: " + calculationType);
        setupSubMenuButtons();
    }

    private void setupSubMenuButtons() {
        Button btnMonto = findViewById(R.id.btnMonto);
        Button btnPlazoAnticipado = findViewById(R.id.btnPlazoAnticipado);
        Button btnTasaDescuento = findViewById(R.id.btnTasaDescuento);

        btnMonto.setOnClickListener(v -> navigateToCalculator("monto"));
        btnPlazoAnticipado.setOnClickListener(v -> navigateToCalculator("plazo_anticipado"));
        btnTasaDescuento.setOnClickListener(v -> navigateToCalculator("tasa_descuento"));
    }

    private void navigateToCalculator(String variable) {
        Intent intent = null;
        Log.d("SubMenuDS", "Navigating with Calculation Type: " + calculationType + ", Variable: " + variable);

        if (calculationType != null) {
            switch (variable) {
                case "monto":
                    intent = new Intent(this, MontoDS.class);
                    break;
                case "plazo_anticipado":
                    intent = new Intent(this, PlazoAnticipado.class);
                    break;
                case "tasa_descuento":
                    intent = new Intent(this, TasaDeDescuento.class);
                    break;
                default:
                    Log.d("SubMenuDS", "Invalid variable: " + variable);
                    return;
            }

            if (intent != null) {
                Log.d("SubMenuDS", "Starting activity for variable: " + variable);
                startActivity(intent);
            } else {
                Log.d("SubMenuDS", "Intent is null for calculationType: " + calculationType + ", Variable: " + variable);
            }
        } else {
            Log.d("SubMenuDS", "CalculationType is null");
        }
    }
}
