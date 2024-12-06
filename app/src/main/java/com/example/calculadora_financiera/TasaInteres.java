package com.example.calculadora_financiera;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TasaInteres extends AppCompatActivity {
    private EditText etMonto, etCapital, etPlazos;
    private TextView tvResultado, tvFormula;
    private Button btnCalcular, btnLimpiar, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasainteres);

        initializeViews();
        setupCalculateButton();
        setupClearButton();
        setupBackButton();
    }

    private void initializeViews() {
        etMonto = findViewById(R.id.etMonto);
        etCapital = findViewById(R.id.etCapital);
        etPlazos = findViewById(R.id.etPlazos);
        tvResultado = findViewById(R.id.tvResultado);
        tvFormula = findViewById(R.id.tvFormula);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnRegresar = findViewById(R.id.btnRegresar);

        tvFormula.setText("Fórmula: i = (M - C) / (C * n)");
    }

    private void setupCalculateButton() {
        btnCalcular.setOnClickListener(v -> calcularTasaInteres());
    }

    private void setupClearButton() {
        btnLimpiar.setOnClickListener(v -> limpiarCampos());
    }

    private void setupBackButton() {
        btnRegresar.setOnClickListener(v -> onBackPressed());
    }

    private void calcularTasaInteres() {
        try {
            String montoStr = etMonto.getText().toString();
            String capitalStr = etCapital.getText().toString();
            String plazosStr = etPlazos.getText().toString();

            if (montoStr.isEmpty() || capitalStr.isEmpty() || plazosStr.isEmpty()) {
                Toast.makeText(this, "Por favor ingrese todos los valores", Toast.LENGTH_SHORT).show();
                return;
            }

            double monto = Double.parseDouble(montoStr);
            double capital = Double.parseDouble(capitalStr);
            double plazos = Double.parseDouble(plazosStr);

            if (plazos == 0) {
                Toast.makeText(this, "El plazo no puede ser cero", Toast.LENGTH_SHORT).show();
                return;
            }

            if (monto < capital) {
                Toast.makeText(this, "El monto no puede ser menor que el capital", Toast.LENGTH_SHORT).show();
                return;
            }

            double tasaInteres = ((monto - capital) / (capital * plazos)) * 100;

            tvResultado.setText(String.format("Tasa de Interés (i) = %.2f%%", tasaInteres));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese valores válidos", Toast.LENGTH_SHORT).show();
            Log.d("TasaInteres", "Error: " + e.getMessage());
        }
    }

    private void limpiarCampos() {
        etMonto.setText("");
        etCapital.setText("");
        etPlazos.setText("");
        tvResultado.setText("");
    }
}
