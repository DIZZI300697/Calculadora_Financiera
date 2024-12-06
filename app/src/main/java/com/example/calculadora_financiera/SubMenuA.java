package com.example.calculadora_financiera;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SubMenuA extends AppCompatActivity {
    private String calculationType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submenua);

        calculationType = getIntent().getStringExtra("CALCULATION_TYPE");
        Log.d("SubMenuA", "Calculation Type: " + calculationType);
        setupSubMenuButtons();
        setupBackButton();
    }

    private void setupSubMenuButtons() {
        Button btnMonto = findViewById(R.id.btnMonto);
        Button btnRenta = findViewById(R.id.btnRenta);
        Button btnNumRentas = findViewById(R.id.btnNumRentas);

        btnMonto.setOnClickListener(v -> navigateToCalculator("monto"));
        btnRenta.setOnClickListener(v -> navigateToCalculator("renta"));
        btnNumRentas.setOnClickListener(v -> navigateToCalculator("num_rentas"));
    }

    private void setupBackButton() {
        Button btnRegresar = findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(v -> onBackPressed());
    }

    private void navigateToCalculator(String variable) {
        Intent intent = null;
        Log.d("SubMenuA", "Navigating with Calculation Type: " + calculationType + ", Variable: " + variable);

        if (calculationType != null) {
            switch (variable) {
                case "monto":
                    intent = new Intent(this, MontoA.class);
                    break;
                case "renta":
                    intent = new Intent(this, Renta.class);
                    break;
                case "num_rentas":
                    intent = new Intent(this, NumRentas.class);
                    break;
                default:
                    Log.d("SubMenuA", "Invalid variable: " + variable);
                    return;
            }

            if (intent != null) {
                Log.d("SubMenuA", "Starting activity for variable: " + variable);
                startActivity(intent);
            } else {
                Log.d("SubMenuA", "Intent is null for calculationType: " + calculationType + ", Variable: " + variable);
            }
        } else {
            Log.d("SubMenuA", "CalculationType is null");
        }
    }
}
