package com.example.calculadora_financiera;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class NumRentas extends AppCompatActivity {
    private EditText etMonto, etRenta, etInteres, etPeriodos;
    private TextView tvResultado, tvFormula;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.numrentas);

        initializeViews();
        setupCalculateButton();
    }

    private void initializeViews() {
        etMonto = findViewById(R.id.etMonto);
        etRenta = findViewById(R.id.etRenta);
        etInteres = findViewById(R.id.etInteres);
        etPeriodos = findViewById(R.id.etPeriodos);
        tvResultado = findViewById(R.id.tvResultado);
        tvFormula = findViewById(R.id.tvFormula);
        btnCalcular = findViewById(R.id.btnCalcular);

        // Mostrar la fórmula corregida
        tvFormula.setText("Fórmula: np = ln((M / R) * (i / p) + 1) / ln(1 + (i / p))");
    }

    private void setupCalculateButton() {
        btnCalcular.setOnClickListener(v -> calcularNumRentas());
    }

    private void calcularNumRentas() {
        try {
            double monto = Double.parseDouble(etMonto.getText().toString());
            double renta = Double.parseDouble(etRenta.getText().toString());
            double interes = Double.parseDouble(etInteres.getText().toString()) / 100; // Convertir a decimal
            double periodos = Double.parseDouble(etPeriodos.getText().toString());

            // Cálculo del número de rentas corregido
            double ratio = 1 + (interes / periodos);
            double numerador = Math.log((monto / renta) * (interes / periodos) + 1);
            double denominador = Math.log(ratio);
            double numRentas = numerador / denominador;

            // Mostrar el resultado con mayor precisión
            tvResultado.setText(String.format("Número de Rentas (np) = %.5f", numRentas));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese valores válidos", Toast.LENGTH_SHORT).show();
        } catch (ArithmeticException e) {
            Toast.makeText(this, "Error: División por cero o valores incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}
