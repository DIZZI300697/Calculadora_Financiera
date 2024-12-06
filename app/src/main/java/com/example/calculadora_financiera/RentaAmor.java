package com.example.calculadora_financiera;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RentaAmor extends AppCompatActivity {
    private EditText etAmortizacion, etIntereses;
    private TextView tvResultado, tvFormula;
    private Button btnCalcular, btnLimpiar, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rentaamor);

        initializeViews();
        setupCalculateButton();
        setupClearButton();
        setupBackButton();
    }

    private void initializeViews() {
        etAmortizacion = findViewById(R.id.etAmortizacion);
        etIntereses = findViewById(R.id.etIntereses);
        tvResultado = findViewById(R.id.tvResultado);
        tvFormula = findViewById(R.id.tvFormula);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnRegresar = findViewById(R.id.btnRegresar);

        tvFormula.setText("Fórmula: R = A + I");
    }

    private void setupCalculateButton() {
        btnCalcular.setOnClickListener(v -> calcularRentaAmor());
    }

    private void setupClearButton() {
        btnLimpiar.setOnClickListener(v -> limpiarCampos());
    }

    private void setupBackButton() {
        btnRegresar.setOnClickListener(v -> onBackPressed());
    }

    private void calcularRentaAmor() {
        try {
            double amortizacion = Double.parseDouble(etAmortizacion.getText().toString());
            double intereses = Double.parseDouble(etIntereses.getText().toString());

            double renta = amortizacion + intereses;

            tvResultado.setText(String.format("Renta (R) = %.2f", renta));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingrese valores válidos", Toast.LENGTH_SHORT).show();
        }
    }

    private void limpiarCampos() {
        etAmortizacion.setText("");
        etIntereses.setText("");
        tvResultado.setText("");
    }
}
