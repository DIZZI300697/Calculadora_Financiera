package com.example.calculadora_financiera;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CapitalIC extends AppCompatActivity {
    private EditText etMonto, etInteres, etPeriodos, etNumPeriodos;
    private TextView tvResultado, tvFormula;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.capitalic);

        initializeViews();
        setupCalculateButton();
    }

    private void initializeViews() {
        etMonto = findViewById(R.id.etMonto);
        etInteres = findViewById(R.id.etInteres);
        etPeriodos = findViewById(R.id.etPeriodos);
        etNumPeriodos = findViewById(R.id.etNumPeriodos);
        tvResultado = findViewById(R.id.tvResultado);
        tvFormula = findViewById(R.id.tvFormula);
        btnCalcular = findViewById(R.id.btnCalcular);

        tvFormula.setText("Fórmula: C = M / (1 + i/p)^(np)");
    }

    private void setupCalculateButton() {
        btnCalcular.setOnClickListener(v -> calcularCapitalIC());
    }

    private void calcularCapitalIC() {
        try {
            double monto = Double.parseDouble(etMonto.getText().toString());
            double interes = Double.parseDouble(etInteres.getText().toString()) / 100;
            double periodos = Double.parseDouble(etPeriodos.getText().toString());
            double numPeriodos = Double.parseDouble(etNumPeriodos.getText().toString());

            double capital = monto / Math.pow(1 + (interes / periodos), numPeriodos * periodos);

            tvResultado.setText(String.format("Capital (C) = %.2f", capital));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese valores válidos", Toast.LENGTH_SHORT).show();
        } catch (ArithmeticException e) {
            Toast.makeText(this, "Error: División por cero o valores incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}
