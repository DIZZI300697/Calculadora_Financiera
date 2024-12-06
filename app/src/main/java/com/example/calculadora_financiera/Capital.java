package com.example.calculadora_financiera;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Capital extends AppCompatActivity {
    private EditText etMonto, etTasaInteres, etPlazos;
    private TextView tvResultado, tvFormula;
    private Button btnCalcular, btnLimpiar, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.capital);

        initializeViews();
        setupCalculateButton();
        setupClearButton();
        setupBackButton();
    }

    private void initializeViews() {
        etMonto = findViewById(R.id.etMonto);
        etTasaInteres = findViewById(R.id.etTasaInteres);
        etPlazos = findViewById(R.id.etPlazos);
        tvResultado = findViewById(R.id.tvResultado);
        tvFormula = findViewById(R.id.tvFormula);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnRegresar = findViewById(R.id.btnRegresar);

        tvFormula.setText("Fórmula: C = M / (1 + i * n)");
    }

    private void setupCalculateButton() {
        btnCalcular.setOnClickListener(v -> calcularCapital());
    }

    private void setupClearButton() {
        btnLimpiar.setOnClickListener(v -> limpiarCampos());
    }

    private void setupBackButton() {
        btnRegresar.setOnClickListener(v -> onBackPressed());
    }

    private void calcularCapital() {
        try {
            double monto = Double.parseDouble(etMonto.getText().toString());
            double tasaInteres = Double.parseDouble(etTasaInteres.getText().toString()) / 100;
            double plazos = Double.parseDouble(etPlazos.getText().toString());

            double capital = monto / (1 + (tasaInteres * plazos));

            tvResultado.setText(String.format("Capital (C) = %.2f", capital));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese valores válidos", Toast.LENGTH_SHORT).show();
        }
    }

    private void limpiarCampos() {
        etMonto.setText("");
        etTasaInteres.setText("");
        etPlazos.setText("");
        tvResultado.setText("");
    }
}
