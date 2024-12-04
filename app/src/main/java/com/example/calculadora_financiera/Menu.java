package com.example.calculadora_financiera;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        setupMenuButtons();
    }

    private void setupMenuButtons() {
        Button btnSimpleInterest = findViewById(R.id.btnInteresSimple);
        Button btnSimpleDiscount = findViewById(R.id.btnDescuentoSimple);
        Button btnCompoundInterest = findViewById(R.id.btnInteresCompuesto);
        Button btnAnnuity = findViewById(R.id.btnAnualidades);
        Button btnAmortization = findViewById(R.id.btnAmortizacion);

        btnSimpleInterest.setOnClickListener(v -> navigateToSubMenu("simple_interest"));
        btnSimpleDiscount.setOnClickListener(v -> navigateToSubMenu("simple_discount"));
        btnCompoundInterest.setOnClickListener(v -> navigateToSubMenu("compound_interest"));
        btnAnnuity.setOnClickListener(v -> navigateToSubMenu("annuity"));
        btnAmortization.setOnClickListener(v -> navigateToSubMenu("amortization"));
    }

    private void navigateToSubMenu(String calculationType) {
        Intent intent = null;

        switch (calculationType) {
            case "simple_interest":
                intent = new Intent(this, SubMenu.class);
                break;
            case "simple_discount":
                intent = new Intent(this, SubMenuDs.class);
                break;
            case "compound_interest":
                // Añadir lógica para compound interest
                break;
            case "annuity":
                // Añadir lógica para annuity
                break;
            case "amortization":
                // Añadir lógica para amortization
                break;
            default:
                // Manejar caso por defecto si es necesario
                break;
        }

        if (intent != null) {
            intent.putExtra("CALCULATION_TYPE", calculationType);
            startActivity(intent);
        }
    }
}
