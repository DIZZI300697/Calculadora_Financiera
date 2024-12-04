package com.example.calculadora_financiera;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Amortizacion extends AppCompatActivity {
    private EditText etRenta, etIntereses;
    private TextView tvResultado, tvFormula;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.amortizacion);

        initializeViews();
        setupCalculateButton();
    }

    private void initializeViews() {
        etRenta = findViewById(R.id.etRenta);
        etIntereses = findViewById(R.id.etIntereses);
        tvResultado = findViewById(R.id.tvResultado);
        tvFormula = findViewById(R.id.tvFormula);
        btnCalcular = findViewById(R.id.btnCalcular);

        // Mostrar la fórmula
        tvFormula.setText("Fórmula: A = R - I");
    }

    private void setupCalculateButton() {
        btnCalcular.setOnClickListener(v -> calcularAmortizacion());
    }

    private void calcularAmortizacion() {
        try {
            double renta = Double.parseDouble(etRenta.getText().toString());
            double intereses = Double.parseDouble(etIntereses.getText().toString());

            double amortizacion = renta - intereses;

            tvResultado.setText(String.format("Amortización (A) = %.2f", amortizacion));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese valores válidos", Toast.LENGTH_SHORT).show();
        }
    }
}
