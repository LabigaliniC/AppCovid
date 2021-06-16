package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static final String EXTRA_IMC = "com.example.imc.imc;";
    public static final String EXTRA_PESO = "com.example.imc.peso;";
    public static final String EXTRA_ALTURA = "com.example.imc.altura;";
    public static final String EXTRA_SERIO = "com.example.imc.serio;";

    private EditText editPeso;
    private EditText editAltura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //editAltura = findViewById(R.id.editAltura);
        //editPeso = findViewById(R.id.editAge);

        Spinner spinner = findViewById(R.id.spinnerEditAge);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.editAge, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this );

        Spinner spinner1 = findViewById(R.id.spinnerEditSpecifications);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.specifications, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this );
    }


    public void calculaIMC(View view) {
        double peso = Double.parseDouble(editPeso.getText().toString());
        double altura = Double.parseDouble(editAltura.getText().toString());
        double imc;

        imc = peso / (altura * altura);

        String serio;
        if (imc < 17) serio = "Muito abaixo do peso";
        else if (imc < 18.50) serio = "Abaixo do peso";
        else if (imc < 25) serio = "Peso Normal";
        else if (imc < 30) serio = "Acima do Peso";
        else if (imc < 35) serio = "Obesidade I";
        else if (imc < 40) serio = "Obesidade II (severa)";
        else serio = "Obesidade III (mórbida)";


        Intent intent = new Intent(this, secondActivity.class);
        intent.putExtra(EXTRA_ALTURA, altura);
        intent.putExtra(EXTRA_PESO, peso);
        intent.putExtra(EXTRA_IMC, imc);
        intent.putExtra(EXTRA_SERIO, serio);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}