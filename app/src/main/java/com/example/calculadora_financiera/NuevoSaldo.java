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
    private Button btnCalcular, btnLimpiar, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevosaldo);

        initializeViews();
        setupCalculateButton();
        setupClearButton();
        setupBackButton();
    }

    private void initializeViews() {
        etSaldo = findViewById(R.id.etSaldo);
        etAmortizacion = findViewById(R.id.etAmortizacion);
        tvResultado = findViewById(R.id.tvResultado);
        tvFormula = findViewById(R.id.tvFormula);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnRegresar = findViewById(R.id.btnRegresar);

        tvFormula.setText("Fórmula: NS = S - A");
    }

    private void setupCalculateButton() {
        btnCalcular.setOnClickListener(v -> calcularNuevoSaldo());
    }

    private void setupClearButton() {
        btnLimpiar.setOnClickListener(v -> limpiarCampos());
    }

    private void setupBackButton() {
        btnRegresar.setOnClickListener(v -> onBackPressed());
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

    private void limpiarCampos() {
        etSaldo.setText("");
        etAmortizacion.setText("");
        tvResultado.setText("");
    }
}
