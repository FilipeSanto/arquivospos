package com.example.filipe.calculaemprestimo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class EmprestimoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emprestimo);
    }

    public void calculaParcela(View view) {

        EditText val = findViewById(R.id.etValor);
        EditText pra = findViewById(R.id.etPrazo);
        EditText tx = findViewById(R.id.etTaxa);
        Button botao = findViewById(R.id.btCalcular);
        RadioButton radioButton1 = findViewById(R.id.rbJurosSimples);
        RadioButton radioButton2 = findViewById(R.id.rbJurosComposto);
        EditText res = findViewById(R.id.etResultado);

        double valor = Double.parseDouble((val).getText().toString());
        double prazo = Double.parseDouble((pra).getText().toString());
        double taxa = Double.parseDouble((tx).getText().toString());
        double resultado = 0;
        double juros = 0;

        if (radioButton2.isChecked()) {
            juros = Math.pow(prazo, (1 + taxa/100)) - 1;
            resultado = (valor + juros) / prazo;

        } else {
            if (radioButton1.isChecked()) {
                    juros = valor * prazo * (taxa/100);
                    resultado = (valor + juros) / prazo;
            }
        }

        res.setText(resultado + "");



    }
}
