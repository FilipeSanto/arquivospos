package com.example.filipe.calculovalorfuturo;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class CalculoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);
    }

    public void Calcular(View view) {

            EditText val = findViewById(R.id.ETxtVLPresente);
            EditText mes = findViewById(R.id.ETxtMeses);
            EditText tx = findViewById(R.id.ETxtJuros);
            Button botao = findViewById(R.id.btCalcula);

            double valor = Double.parseDouble((val).getText().toString());
            double prazo = Double.parseDouble((mes).getText().toString());
            double taxa = Double.parseDouble((tx).getText().toString());
            double resultado = 0;
            double juros = 0;

            juros = valor * prazo * (taxa/100);
            resultado = valor + juros;

            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("Resultado");
            dialog.setMessage("Valor atualizado: " + resultado);
            dialog.show();

    }
}
