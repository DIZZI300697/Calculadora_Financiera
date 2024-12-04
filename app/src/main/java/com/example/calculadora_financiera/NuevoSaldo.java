package com.example.calculadora_financiera;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class NuevoSaldo extends AppCompatActivity {
    private EditText etSaldo, etAmortizacion;
    private TextView tvResultado, tvFormula;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevosaldo);

        initializeViews();
        setupCalculateButton();
    }

    private void initializeViews() {
        etSaldo = findViewById(R.id.etSaldo);
        etAmortizacion = findViewById(R.id.etAmortizacion);
        tvResultado = findViewById(R.id.tvResultado);
        tvFormula = findViewById(R.id.tvFormula);
        btnCalcular = findViewById(R.id.btnCalcular);

        // Mostrar la fórmula
        tvFormula.setText("Fórmula: NS = S - A");
    }

    private void setupCalculateButton() {
        btnCalcular.setOnClickListener(v -> calcularNuevoSaldo());
    }

    private void calcularNuevoSaldo() {
        try {
            double saldo = Double.parseDouble(etSaldo.getText().toString());
            double amortizacion = Double.parseDouble(etAmortizacion.getText().toString());

            double nuevoSaldo = saldo - amortizacion;

            tvResultado.setText(String.format("Nuevo Saldo (NS) = %.2f", nuevoSaldo));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese valores válidos", Toast.LENGTH_SHORT).show();
        }
    }
}
