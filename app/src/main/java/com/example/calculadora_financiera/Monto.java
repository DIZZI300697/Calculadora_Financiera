package com.example.calculadora_financiera;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculadora_financiera.R;

public class Monto extends AppCompatActivity {
    private EditText etCapital, etInteres, etPlazos;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monto);
        Log.d("Monto", "onCreate called");

        initializeViews();
        setupCalculateButton();
    }

    private void initializeViews() {
        etCapital = findViewById(R.id.etCapital);
        etInteres = findViewById(R.id.etInteres);
        etPlazos = findViewById(R.id.etPlazos);
        tvResultado = findViewById(R.id.tvResultado);
    }

    private void setupCalculateButton() {
        Button btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(v -> calcularMonto());
    }

    private void calcularMonto() {
        try {
            double capital = Double.parseDouble(etCapital.getText().toString());
            double tasaInteres = Double.parseDouble(etInteres.getText().toString()) / 100; // Convertir a decimal
            double plazos = Double.parseDouble(etPlazos.getText().toString());

            double monto = capital * (1 + tasaInteres * plazos);

            tvResultado.setText(String.format("Monto: %.2f", monto));
            Log.d("Monto", "Monto calculado: " + monto);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese valores válidos", Toast.LENGTH_SHORT).show();
            Log.d("Monto", "Error: " + e.getMessage());
        }
    }
}
