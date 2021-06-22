package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
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
    public static final String EXTRA_PRIORITY = "com.example.imc.priority;";
    private static final String TAG = "MainActivity";
    private Spinner spinnerSpecifications;

    private EditText editPeso;
    private EditText editAltura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //editAltura = findViewById(R.id.editAltura);
        //editPeso = findViewById(R.id.editAge);

        spinnerSpecifications = findViewById(R.id.spinnerEditSpecifications);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.specifications,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSpecifications.setAdapter(adapter);
        spinnerSpecifications.setOnItemSelectedListener(this);

    }

    public void calcularPrevisaoVacinacao(View view) {
//        double peso = Double.parseDouble(editPeso.getText().toString());
//        double altura = Double.parseDouble(editAltura.getText().toString());
//        double imc;
//
//        imc = peso / (altura * altura);
//
//        String serio;
//        if (imc < 17) serio = "Muito abaixo do peso";
//        else if (imc < 18.50) serio = "Abaixo do peso";
//        else if (imc < 25) serio = "Peso Normal";
//        else if (imc < 30) serio = "Acima do Peso";
//        else if (imc < 35) serio = "Obesidade I";
//        else if (imc < 40) serio = "Obesidade II (severa)";
//        else serio = "Obesidade III (mórbida)";
//
       Intent intent = new Intent(this, secondActivity.class);
//        intent.putExtra(EXTRA_ALTURA, altura);
//        intent.putExtra(EXTRA_PESO, peso);
//        intent.putExtra(EXTRA_IMC, imc);
        String priority = "";
        intent.putExtra(EXTRA_PRIORITY, priority);
        startActivity(intent);

        Log.d(TAG, "calcularPrevisaoVacinacao: " + spinnerSpecifications.getSelectedItem().toString());


        if ((boolean) spinnerSpecifications.getItemAtPosition(1)){
            priority = "Prioridade 1 - Data para iniciar a Vacinação dia 01/04/2021 à 01/05/2021 ";
        }
        else if ((boolean)spinnerSpecifications.getItemAtPosition(2)){
            priority = "Prioridade 2 - Data para iniciar a Vacinação dia 01/05/2021 à 01/06/2021 ";
        }
        /*else if (spinnerSpecifications.getSelectedItem(3)){
            priority = "Prioridade 3 - Data para iniciar a Vacinação dia 01/06/2021 à 01/07/2021 ";
        }
        else if (spinnerSpecifications.getSelectedItem(4)){
            priority = "Prioridade 4 - Data para iniciar a Vacinação dia 01/07/2021 à 01/08/2021 ";
        }
        else if (spinnerSpecifications.getSelectedItem(5)){
            priority = "Prioridade 5 - Data para iniciar a Vacinação dia 01/08/2021 à 01/09/2021 ";
        }
        else if (spinnerSpecifications.getSelectedItem(6)){
            priority = "Prioridade 6 - Data para iniciar a Vacinação dia 01/09/2021 à 01/10/2021 ";
        }
        else if (spinnerSpecifications.getSelectedItem(7)){
            priority = "Prioridade 7 - Data para iniciar a Vacinação dia 01/10/2021 à 01/11/2021 ";
        }
        else if (spinnerSpecifications.getSelectedItem(8)){
            priority = "Prioridade 8 - Data para iniciar a Vacinação dia 01/11/2021 à 01/12/2021 ";
        }
        else if (spinnerSpecifications.getSelectedItem(9)){
            priority = "Prioridade 9 - Data para iniciar a Vacinação dia 01/12/2021 à 01/01/2022 ";
        }
        else if (spinnerSpecifications.getSelectedItem(10)){
            priority = "Prioridade 10 - Data para iniciar a Vacinação dia 01/01/2022 à 01/02/2022 ";
        }
        else if (spinnerSpecifications.getSelectedItem(11)){
            priority = "Prioridade 11 - Data para iniciar a Vacinação dia 01/02/2022 à 01/03/2022 ";
        }
        else if (spinnerSpecifications.getSelectedItem(12)){
            priority = "Prioridade 12 - Data para iniciar a Vacinação dia 01/03/2022 à 01/04/2022 ";
        }
        else if (spinnerSpecifications.getSelectedItem(13)){
            priority = "Prioridade 13 - Data para iniciar a Vacinação dia 01/04/2022 à 01/05/2022 ";
        }
        else if (spinnerSpecifications.getSelectedItem(14)){
            priority = "Prioridade 14 - Data para iniciar a Vacinação dia 01/05/2022 à 01/06/2022 ";
        }
        else if (spinnerSpecifications.getSelectedItem(15)){
            priority = "Prioridade 15 - Data para iniciar a Vacinação dia 01/06/2022 à 01/07/2022 ";
        }
        else if (spinnerSpecifications.getSelectedItem(16)){
            priority = "Prioridade 16 - Data para iniciar a Vacinação dia 01/07/2022 à 01/08/2022 ";
        }
        else if (spinnerSpecifications.getSelectedItem(17)){
            priority = "Prioridade 17 - Data para iniciar a Vacinação dia 01/08/2022 à 01/09/2022 ";
        }
        else if (spinnerSpecifications.getSelectedItem(18)){
            priority = "Prioridade 18 - Data para iniciar a Vacinação dia 01/09/2022 à 01/10/2022 ";
        }
        else if (spinnerSpecifications.getSelectedItem(19)){
            priority = "Prioridade 19 - Data para iniciar a Vacinação dia 01/10/2022 à 01/11/2022 ";
        }*/
        
        
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