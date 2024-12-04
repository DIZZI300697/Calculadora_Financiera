package com.example.calculadora_financiera;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MontoIC extends AppCompatActivity {
    private EditText etCapital, etInteres, etPeriodos, etNumPeriodos;
    private TextView tvResultado, tvFormula;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.montoic);

        initializeViews();
        setupCalculateButton();
    }

    private void initializeViews() {
        etCapital = findViewById(R.id.etCapital);
        etInteres = findViewById(R.id.etInteres);
        etPeriodos = findViewById(R.id.etPeriodos);
        etNumPeriodos = findViewById(R.id.etNumPeriodos);
        tvResultado = findViewById(R.id.tvResultado);
        tvFormula = findViewById(R.id.tvFormula);
        btnCalcular = findViewById(R.id.btnCalcular);

        tvFormula.setText("Fórmula: M = C * (1 + i/p)^(np)");
    }

    private void setupCalculateButton() {
        btnCalcular.setOnClickListener(v -> calcularMontoIC());
    }

    private void calcularMontoIC() {
        try {
            double capital = Double.parseDouble(etCapital.getText().toString());
            double interes = Double.parseDouble(etInteres.getText().toString()) / 100;
            double periodos = Double.parseDouble(etPeriodos.getText().toString());
            double numPeriodos = Double.parseDouble(etNumPeriodos.getText().toString());

            double monto = capital * Math.pow(1 + (interes / periodos), numPeriodos * periodos);

            tvResultado.setText(String.format("Monto (M) = %.2f", monto));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese valores válidos", Toast.LENGTH_SHORT).show();
        } catch (ArithmeticException e) {
            Toast.makeText(this, "Error: División por cero o valores incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}
