package com.example.calculadora_financiera;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculadora_financiera.R;

public class TasaInteres extends AppCompatActivity {
    private EditText etMonto, etCapital, etPlazos;
    private TextView tvResultado, tvFormula;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasainteres);

        initializeViews();
        setupCalculateButton();
    }

    private void initializeViews() {
        etMonto = findViewById(R.id.etMonto);
        etCapital = findViewById(R.id.etCapital);
        etPlazos = findViewById(R.id.etPlazos);
        tvResultado = findViewById(R.id.tvResultado);
        tvFormula = findViewById(R.id.tvFormula);
        btnCalcular = findViewById(R.id.btnCalcular);

        // Mostrar la fórmula
        tvFormula.setText("Fórmula: i = (M - C) / (C * n)");
    }

    private void setupCalculateButton() {
        btnCalcular.setOnClickListener(v -> calcularTasaInteres());
    }

    private void calcularTasaInteres() {
        try {
            double monto = Double.parseDouble(etMonto.getText().toString());
            double capital = Double.parseDouble(etCapital.getText().toString());
            double plazos = Double.parseDouble(etPlazos.getText().toString());

            // Calcular la tasa de interés
            double tasaInteres = ((monto - capital) / (capital * plazos)) * 100; // Convertir a porcentaje

            tvResultado.setText(String.format("Tasa de Interés (i) = %.2f%%", tasaInteres));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese valores válidos", Toast.LENGTH_SHORT).show();
            Log.d("TasaInteres", "Error: " + e.getMessage());
        } catch (ArithmeticException e) {
            Toast.makeText(this, "Error: División por cero", Toast.LENGTH_SHORT).show();
            Log.d("TasaInteres", "Error: " + e.getMessage());
        }
    }
}
