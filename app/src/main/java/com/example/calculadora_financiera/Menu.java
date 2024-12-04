package com.example.calculadora_financiera;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculadora_financiera.R;

public class Menu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);  // Asegúrate de que tu archivo XML se llama "menu.xml"

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
        Intent intent = new Intent(this, SubMenu.class);
        intent.putExtra("CALCULATION_TYPE", calculationType);
        startActivity(intent);
    }
}
