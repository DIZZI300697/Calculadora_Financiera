package com.example.calculadora_financiera;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Renta extends AppCompatActivity {
    private EditText etMonto, etInteres, etPeriodos, etNumPeriodos;
    private TextView tvResultado, tvFormula;
    private Button btnCalcular, btnLimpiar, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.renta);

        initializeViews();
        setupCalculateButton();
        setupClearButton();
        setupBackButton();
    }

    private void initializeViews() {
        etMonto = findViewById(R.id.etMonto);
        etInteres = findViewById(R.id.etInteres);
        etPeriodos = findViewById(R.id.etPeriodos);
        etNumPeriodos = findViewById(R.id.etNumPeriodos);
        tvResultado = findViewById(R.id.tvResultado);
        tvFormula = findViewById(R.id.tvFormula);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnRegresar = findViewById(R.id.btnRegresar);

        // Mostrar la fórmula ajustada
        tvFormula.setText("Fórmula: R = M * (i/p) / [(1 + i/p) * ((1 + i/p)^np - 1) / (i/p)]");
    }

    private void setupCalculateButton() {
        btnCalcular.setOnClickListener(v -> calcularRenta());
    }

    private void setupClearButton() {
        btnLimpiar.setOnClickListener(v -> limpiarCampos());
    }

    private void setupBackButton() {
        btnRegresar.setOnClickListener(v -> onBackPressed());
    }

    private void calcularRenta() {
        try {
            if (etMonto.getText().toString().isEmpty() ||
                    etInteres.getText().toString().isEmpty() ||
                    etPeriodos.getText().toString().isEmpty() ||
                    etNumPeriodos.getText().toString().isEmpty()) {
                throw new NumberFormatException();
            }

            double monto = Double.parseDouble(etMonto.getText().toString());
            double interes = Double.parseDouble(etInteres.getText().toString()) / 100; // Convertir a decimal
            double periodos = Double.parseDouble(etPeriodos.getText().toString());
            double numPeriodos = Double.parseDouble(etNumPeriodos.getText().toString());

            double factorInteres = interes / periodos;
            double renta = monto / (((Math.pow(1 + factorInteres, numPeriodos) - 1) / factorInteres) * (1 + factorInteres));

            tvResultado.setText(String.format("Renta (R) = %.7f", renta));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese valores válidos en todos los campos", Toast.LENGTH_SHORT).show();
        } catch (ArithmeticException e) {
            Toast.makeText(this, "Error: División por cero o valores incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

    private void limpiarCampos() {
        etMonto.setText("");
        etInteres.setText("");
        etPeriodos.setText("");
        etNumPeriodos.setText("");
        tvResultado.setText("");
    }
}
