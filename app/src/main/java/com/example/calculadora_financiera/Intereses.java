package com.example.calculadora_financiera;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Intereses extends AppCompatActivity {
    private EditText etSaldo, etInteres, etPeriodos;
    private TextView tvResultado, tvFormula;
    private Button btnCalcular, btnLimpiar, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intereses);

        initializeViews();
        setupCalculateButton();
        setupClearButton();
        setupBackButton();
    }

    private void initializeViews() {
        etSaldo = findViewById(R.id.etSaldo);
        etInteres = findViewById(R.id.etInteres);
        etPeriodos = findViewById(R.id.etPeriodos);
        tvResultado = findViewById(R.id.tvResultado);
        tvFormula = findViewById(R.id.tvFormula);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnRegresar = findViewById(R.id.btnRegresar);

        tvFormula.setText("Fórmula: I = S * (i / p)");
    }

    private void setupCalculateButton() {
        btnCalcular.setOnClickListener(v -> calcularIntereses());
    }

    private void setupClearButton() {
        btnLimpiar.setOnClickListener(v -> limpiarCampos());
    }

    private void setupBackButton() {
        btnRegresar.setOnClickListener(v -> onBackPressed());
    }

    private void calcularIntereses() {
        try {
            double saldo = Double.parseDouble(etSaldo.getText().toString());
            double interes = Double.parseDouble(etInteres.getText().toString()) / 100;
            double periodos = Double.parseDouble(etPeriodos.getText().toString());

            double intereses = saldo * (interes / periodos);

            tvResultado.setText(String.format("Intereses (I) = %.2f", intereses));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese valores válidos", Toast.LENGTH_SHORT).show();
        } catch (ArithmeticException e) {
            Toast.makeText(this, "Error: División por cero o valores incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

    private void limpiarCampos() {
        etSaldo.setText("");
        etInteres.setText("");
        etPeriodos.setText("");
        tvResultado.setText("");
    }
}
