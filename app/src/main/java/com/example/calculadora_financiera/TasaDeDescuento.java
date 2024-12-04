package com.example.calculadora_financiera;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TasaDeDescuento extends AppCompatActivity {
    private EditText etPrincipal, etMonto, etPlazos;
    private TextView tvResultado, tvFormula;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasadedescuento);

        initializeViews();
        setupCalculateButton();
    }

    private void initializeViews() {
        etPrincipal = findViewById(R.id.etPrincipal);
        etMonto = findViewById(R.id.etMonto);
        etPlazos = findViewById(R.id.etPlazos);
        tvResultado = findViewById(R.id.tvResultado);
        tvFormula = findViewById(R.id.tvFormula);
        btnCalcular = findViewById(R.id.btnCalcular);

        tvFormula.setText("Fórmula: d = (1 - (P / M)) / n");
    }

    private void setupCalculateButton() {
        btnCalcular.setOnClickListener(v -> calcularTasaDeDescuento());
    }

    private void calcularTasaDeDescuento() {
        try {
            double principal = Double.parseDouble(etPrincipal.getText().toString());
            double monto = Double.parseDouble(etMonto.getText().toString());
            double plazos = Double.parseDouble(etPlazos.getText().toString());

            double tasaDescuento = (1 - (principal / monto)) / plazos;

            tvResultado.setText(String.format("Tasa de Descuento (d) = %.2f%%", tasaDescuento * 100));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese valores válidos", Toast.LENGTH_SHORT).show();
        } catch (ArithmeticException e) {
            Toast.makeText(this, "Error: División por cero o valores incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}
