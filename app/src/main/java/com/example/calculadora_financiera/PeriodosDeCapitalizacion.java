package com.example.calculadora_financiera;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PeriodosDeCapitalizacion extends AppCompatActivity {
    private EditText etMonto, etCapital, etInteres, etPeriodos;
    private TextView tvResultado, tvFormula;
    private Button btnCalcular, btnLimpiar, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.periodosdecapitalizacion);

        initializeViews();
        setupCalculateButton();
        setupClearButton();
        setupBackButton();
    }

    private void initializeViews() {
        etMonto = findViewById(R.id.etMonto);
        etCapital = findViewById(R.id.etCapital);
        etInteres = findViewById(R.id.etInteres);
        etPeriodos = findViewById(R.id.etPeriodos);
        tvResultado = findViewById(R.id.tvResultado);
        tvFormula = findViewById(R.id.tvFormula);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnRegresar = findViewById(R.id.btnRegresar);

        tvFormula.setText("Fórmula: np = ln(M/C) / ln(1 + i/p)");
    }

    private void setupCalculateButton() {
        btnCalcular.setOnClickListener(v -> calcularPeriodosDeCapitalizacion());
    }

    private void setupClearButton() {
        btnLimpiar.setOnClickListener(v -> limpiarCampos());
    }

    private void setupBackButton() {
        btnRegresar.setOnClickListener(v -> onBackPressed());
    }

    private void calcularPeriodosDeCapitalizacion() {
        try {
            double monto = Double.parseDouble(etMonto.getText().toString());
            double capital = Double.parseDouble(etCapital.getText().toString());
            double interes = Double.parseDouble(etInteres.getText().toString()) / 100;
            double periodos = Double.parseDouble(etPeriodos.getText().toString());

            double periodosDeCapitalizacion = Math.log(monto / capital) / Math.log(1 + (interes / periodos));

            tvResultado.setText(String.format("Periodos de Capitalización (np) = %.2f", periodosDeCapitalizacion));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese valores válidos", Toast.LENGTH_SHORT).show();
        } catch (ArithmeticException e) {
            Toast.makeText(this, "Error: División por cero o valores incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

    private void limpiarCampos() {
        etMonto.setText("");
        etCapital.setText("");
        etInteres.setText("");
        etPeriodos.setText("");
        tvResultado.setText("");
    }
}
