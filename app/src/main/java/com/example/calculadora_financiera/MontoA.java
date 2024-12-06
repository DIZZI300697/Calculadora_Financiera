package com.example.calculadora_financiera;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MontoA extends AppCompatActivity {
    private EditText etRenta, etInteres, etPeriodos, etNumPeriodos;
    private TextView tvResultado, tvFormula;
    private Button btnCalcular, btnLimpiar, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.montoa);

        initializeViews();
        setupCalculateButton();
        setupClearButton();
        setupBackButton();
    }

    private void initializeViews() {
        etRenta = findViewById(R.id.etRenta);
        etInteres = findViewById(R.id.etInteres);
        etPeriodos = findViewById(R.id.etPeriodos);
        etNumPeriodos = findViewById(R.id.etNumPeriodos);
        tvResultado = findViewById(R.id.tvResultado);
        tvFormula = findViewById(R.id.tvFormula);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnRegresar = findViewById(R.id.btnRegresar);

        tvFormula.setText("Fórmula: M = R * (1 + i/p) * ((1 + i/p)^np - 1) / (i/p)");
    }

    private void setupCalculateButton() {
        btnCalcular.setOnClickListener(v -> calcularMontoA());
    }

    private void setupClearButton() {
        btnLimpiar.setOnClickListener(v -> limpiarCampos());
    }

    private void setupBackButton() {
        btnRegresar.setOnClickListener(v -> onBackPressed());
    }

    private void calcularMontoA() {
        try {
            double renta = Double.parseDouble(etRenta.getText().toString());
            double interes = Double.parseDouble(etInteres.getText().toString()) / 100;
            double periodos = Double.parseDouble(etPeriodos.getText().toString());
            double numPeriodos = Double.parseDouble(etNumPeriodos.getText().toString());

            double monto = renta * (1 + (interes / periodos)) * ((Math.pow(1 + (interes / periodos), numPeriodos * periodos) - 1) / (interes / periodos));

            tvResultado.setText(String.format("Monto (M) = %.2f", monto));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese valores válidos", Toast.LENGTH_SHORT).show();
        } catch (ArithmeticException e) {
            Toast.makeText(this, "Error: División por cero o valores incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

    private void limpiarCampos() {
        etRenta.setText("");
        etInteres.setText("");
        etPeriodos.setText("");
        etNumPeriodos.setText("");
        tvResultado.setText("");
    }
}
