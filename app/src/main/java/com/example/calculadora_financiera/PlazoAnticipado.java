package com.example.calculadora_financiera;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PlazoAnticipado extends AppCompatActivity {
    private EditText etPrincipal, etMonto, etTasaDescuento;
    private TextView tvResultado, tvFormula;
    private Button btnCalcular, btnLimpiar, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plazoanticipado);

        initializeViews();
        setupCalculateButton();
        setupClearButton();
        setupBackButton();
    }

    private void initializeViews() {
        etPrincipal = findViewById(R.id.etPrincipal);
        etMonto = findViewById(R.id.etMonto);
        etTasaDescuento = findViewById(R.id.etTasaDescuento);
        tvResultado = findViewById(R.id.tvResultado);
        tvFormula = findViewById(R.id.tvFormula);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnRegresar = findViewById(R.id.btnRegresar);

        tvFormula.setText("Fórmula: n = (1 - (P / M)) / d");
    }

    private void setupCalculateButton() {
        btnCalcular.setOnClickListener(v -> calcularPlazoAnticipado());
    }

    private void setupClearButton() {
        btnLimpiar.setOnClickListener(v -> limpiarCampos());
    }

    private void setupBackButton() {
        btnRegresar.setOnClickListener(v -> onBackPressed());
    }

    private void calcularPlazoAnticipado() {
        try {
            double principal = Double.parseDouble(etPrincipal.getText().toString());
            double monto = Double.parseDouble(etMonto.getText().toString());
            double tasaDescuento = Double.parseDouble(etTasaDescuento.getText().toString()) / 100;

            double plazo = (1 - (principal / monto)) / tasaDescuento;

            tvResultado.setText(String.format("Plazo Anticipado (n) = %.2f", plazo));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese valores válidos", Toast.LENGTH_SHORT).show();
        } catch (ArithmeticException e) {
            Toast.makeText(this, "Error: División por cero o valores incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

    private void limpiarCampos() {
        etPrincipal.setText("");
        etMonto.setText("");
        etTasaDescuento.setText("");
        tvResultado.setText("");
    }
}
