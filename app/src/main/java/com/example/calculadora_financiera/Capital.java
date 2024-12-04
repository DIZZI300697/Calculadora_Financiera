package com.example.calculadora_financiera;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculadora_financiera.R;

public class Capital extends AppCompatActivity {
    private EditText etMonto, etTasaInteres, etPlazos;
    private TextView tvResultado, tvFormula;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.capital);

        initializeViews();
        setupCalculateButton();
    }

    private void initializeViews() {
        etMonto = findViewById(R.id.etMonto);
        etTasaInteres = findViewById(R.id.etTasaInteres);
        etPlazos = findViewById(R.id.etPlazos);
        tvResultado = findViewById(R.id.tvResultado);
        tvFormula = findViewById(R.id.tvFormula);
        btnCalcular = findViewById(R.id.btnCalcular);

        // Mostrar la fórmula
        tvFormula.setText("Fórmula: C = M / (1 + in)");
    }

    private void setupCalculateButton() {
        btnCalcular.setOnClickListener(v -> calcularCapital());
    }

    private void calcularCapital() {
        try {
            double monto = Double.parseDouble(etMonto.getText().toString());
            double tasaInteres = Double.parseDouble(etTasaInteres.getText().toString()) / 100; // Convertir a decimal
            double plazos = Double.parseDouble(etPlazos.getText().toString());

            double capital = monto / (1 + (tasaInteres * plazos));

            tvResultado.setText(String.format("Capital (C) = %.2f", capital));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese valores válidos", Toast.LENGTH_SHORT).show();
        }
    }
}
