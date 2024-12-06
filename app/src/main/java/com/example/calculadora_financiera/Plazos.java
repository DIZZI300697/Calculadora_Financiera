package com.example.calculadora_financiera;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Plazos extends AppCompatActivity {
    private EditText etMonto, etCapital, etInteres;
    private TextView tvResultado, tvFormula;
    private Button btnCalcular, btnLimpiar, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plazos);

        initializeViews();
        setupCalculateButton();
        setupClearButton();
        setupBackButton();
    }

    private void initializeViews() {
        etMonto = findViewById(R.id.etMonto);
        etCapital = findViewById(R.id.etCapital);
        etInteres = findViewById(R.id.etInteres);
        tvResultado = findViewById(R.id.tvResultado);
        tvFormula = findViewById(R.id.tvFormula);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnRegresar = findViewById(R.id.btnRegresar);

        tvFormula.setText("Fórmula: n = (M - C) / (C * i)");
    }

    private void setupCalculateButton() {
        btnCalcular.setOnClickListener(v -> calcularPlazos());
    }

    private void setupClearButton() {
        btnLimpiar.setOnClickListener(v -> limpiarCampos());
    }

    private void setupBackButton() {
        btnRegresar.setOnClickListener(v -> onBackPressed());
    }

    private void calcularPlazos() {
        try {
            double monto = Double.parseDouble(etMonto.getText().toString());
            double capital = Double.parseDouble(etCapital.getText().toString());
            double tasaInteres = Double.parseDouble(etInteres.getText().toString()) / 100;

            double plazos = (monto - capital) / (capital * tasaInteres);

            tvResultado.setText(String.format("Plazo (n) = %.2f años", plazos));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese valores válidos", Toast.LENGTH_SHORT).show();
            Log.d("Plazos", "Error: " + e.getMessage());
        } catch (ArithmeticException e) {
            Toast.makeText(this, "Error: División por cero", Toast.LENGTH_SHORT).show();
            Log.d("Plazos", "Error: " + e.getMessage());
        }
    }

    private void limpiarCampos() {
        etMonto.setText("");
        etCapital.setText("");
        etInteres.setText("");
        tvResultado.setText("");
    }
}
