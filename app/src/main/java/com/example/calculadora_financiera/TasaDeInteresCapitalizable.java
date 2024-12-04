package com.example.calculadora_financiera;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TasaDeInteresCapitalizable extends AppCompatActivity {
    private EditText etMonto, etCapital, etNumPeriodos, etPeriodos;
    private TextView tvResultado, tvFormula;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasadeinterescapitalizable);

        initializeViews();
        setupCalculateButton();
    }

    private void initializeViews() {
        etMonto = findViewById(R.id.etMonto);
        etCapital = findViewById(R.id.etCapital);
        etNumPeriodos = findViewById(R.id.etNumPeriodos);
        etPeriodos = findViewById(R.id.etPeriodos);
        tvResultado = findViewById(R.id.tvResultado);
        tvFormula = findViewById(R.id.tvFormula);
        btnCalcular = findViewById(R.id.btnCalcular);

        tvFormula.setText("Fórmula: i = ( (M/C)^(1/np) - 1 ) * p");
    }

    private void setupCalculateButton() {
        btnCalcular.setOnClickListener(v -> calcularTasaDeInteresCapitalizable());
    }

    private void calcularTasaDeInteresCapitalizable() {
        try {
            double monto = Double.parseDouble(etMonto.getText().toString());
            double capital = Double.parseDouble(etCapital.getText().toString());
            double numPeriodos = Double.parseDouble(etNumPeriodos.getText().toString());
            double periodos = Double.parseDouble(etPeriodos.getText().toString());

            double tasaInteres = (Math.pow(monto / capital, 1 / (numPeriodos * periodos)) - 1) * periodos;

            tvResultado.setText(String.format("Tasa de Interés Capitalizable (i) = %.2f%%", tasaInteres * 100));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese valores válidos", Toast.LENGTH_SHORT).show();
        } catch (ArithmeticException e) {
            Toast.makeText(this, "Error: División por cero o valores incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}
