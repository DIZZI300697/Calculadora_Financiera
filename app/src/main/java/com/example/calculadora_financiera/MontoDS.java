package com.example.calculadora_financiera;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MontoDS extends AppCompatActivity {
    private EditText etPrincipal, etPlazos, etTasaDescuento;
    private TextView tvResultado, tvFormula;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.montods);

        initializeViews();
        setupCalculateButton();
    }

    private void initializeViews() {
        etPrincipal = findViewById(R.id.etPrincipal);
        etPlazos = findViewById(R.id.etPlazos);
        etTasaDescuento = findViewById(R.id.etTasaDescuento);
        tvResultado = findViewById(R.id.tvResultado);
        tvFormula = findViewById(R.id.tvFormula);
        btnCalcular = findViewById(R.id.btnCalcular);

        tvFormula.setText("Fórmula: M = P / (1 - (n * d))");
    }

    private void setupCalculateButton() {
        btnCalcular.setOnClickListener(v -> calcularMontoDS());
    }

    private void calcularMontoDS() {
        try {
            double principal = Double.parseDouble(etPrincipal.getText().toString());
            double tasaDescuento = Double.parseDouble(etTasaDescuento.getText().toString()) / 100;
            double plazos = Double.parseDouble(etPlazos.getText().toString());

            double monto = principal / (1 - (plazos * tasaDescuento));

            tvResultado.setText(String.format("Monto (M) = %.2f", monto));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese valores válidos", Toast.LENGTH_SHORT).show();
        } catch (ArithmeticException e) {
            Toast.makeText(this, "Error: División por cero o valores incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}
