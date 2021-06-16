package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView showPeso = findViewById(R.id.showPeso);
        TextView showAltura = findViewById(R.id.showAltura);
        TextView showIMC = findViewById(R.id.showIMC);
        TextView showSituacao = findViewById(R.id.showSituacao);

        Intent intent = getIntent();
        double peso = intent.getDoubleExtra(MainActivity.EXTRA_PESO, 0);
        double altura = intent.getDoubleExtra(MainActivity.EXTRA_ALTURA, 0);
        double imc = intent.getDoubleExtra(MainActivity.EXTRA_IMC, 0);
        String serio = intent.getStringExtra(MainActivity.EXTRA_SERIO);
        String imcFormat = new DecimalFormat("##0.00").format(imc);

        showPeso.setText(Double.toString(peso));
        showAltura.setText(Double.toString(altura));
        showIMC.setText(Double.toString(Double.parseDouble(imcFormat)));
        showSituacao.setText(serio);
    }
}