package com.example.filipe.conversaomoedas;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ConversaoMoedasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversao_moedas);
    }

    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        RadioGroup radioGroup = findViewById(R.id.rdIdioma);

        String radioValue = ((RadioButton) findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
        TextView tvAux;
        TextView tvAux2;
        TextView tvAux3;
        TextView tvAux4;
        TextView tvAux5;
        TextView tvAux6;
        TextView tvAux7;
        TextView tvAux8;
        switch (view.getId()) {
            case R.id.rbEnglish:
                if (checked) {
                    tvAux = (TextView) findViewById(R.id.tvIdioma);
                    tvAux.setText("Convert Currencies");
                    tvAux2 = (TextView) findViewById(R.id.tvConvert);
                    tvAux2.setText("Choose Conversion");
                    tvAux3 = (TextView) findViewById(R.id.rbRealDolar);
                    tvAux3.setText("Real to Dollar");
                    tvAux4 = (TextView) findViewById(R.id.rbDolarReal);
                    tvAux4.setText("Dollar to Real");
                    tvAux5 = (TextView) findViewById(R.id.rbRealEuro);
                    tvAux5.setText("Real to Euro");
                    tvAux6 = (TextView) findViewById(R.id.rbEuroReal);
                    tvAux6.setText("Euro to Real");
                    tvAux7 = (TextView) findViewById(R.id.rbDolarEuro);
                    tvAux7.setText("Dollar to Euro");
                    tvAux8 = (TextView) findViewById(R.id.rbEuroDolar);
                    tvAux8.setText("Euro to Dollar");

                }
                break;
            case R.id.rbEspanol:
                if (checked) {
                    tvAux = (TextView) findViewById(R.id.tvIdioma);
                    tvAux.setText("Convertir Monedas");
                    tvAux2 = (TextView) findViewById(R.id.tvConvert);
                    tvAux2.setText("Elija la conversión");
                    tvAux3 = (TextView) findViewById(R.id.rbRealDolar);
                    tvAux3.setText("Real para Dolar");
                    tvAux4 = (TextView) findViewById(R.id.rbDolarReal);
                    tvAux4.setText("Dolar para Real");
                    tvAux5 = (TextView) findViewById(R.id.rbRealEuro);
                    tvAux5.setText("Real para Euro");
                    tvAux6 = (TextView) findViewById(R.id.rbEuroReal);
                    tvAux6.setText("Euro para Real");
                    tvAux7 = (TextView) findViewById(R.id.rbDolarEuro);
                    tvAux7.setText("Dolar para Euro");
                    tvAux8 = (TextView) findViewById(R.id.rbEuroDolar);
                    tvAux8.setText("Euro para Dolar");
                }
                break;
            case R.id.rbPortugues:
                if (checked) {
                    tvAux = (TextView) findViewById(R.id.tvIdioma);
                    tvAux.setText("Converter moedas");
                    tvAux2 = (TextView) findViewById(R.id.tvConvert);
                    tvAux2.setText("Escolha a conversão");
                    tvAux3 = (TextView) findViewById(R.id.rbRealDolar);
                    tvAux3.setText("Real para Dólar");
                    tvAux4 = (TextView) findViewById(R.id.rbDolarReal);
                    tvAux4.setText("Dólar para Real");
                    tvAux5 = (TextView) findViewById(R.id.rbRealEuro);
                    tvAux5.setText("Real para Euro");
                    tvAux6 = (TextView) findViewById(R.id.rbEuroReal);
                    tvAux6.setText("Euro para Real");
                    tvAux7 = (TextView) findViewById(R.id.rbDolarEuro);
                    tvAux7.setText("Dólar para Euro");
                    tvAux8 = (TextView) findViewById(R.id.rbEuroDolar);
                    tvAux8.setText("Euro para Dólar");
                }
                break;
        }


    }

    public void Converter(View view) {


        EditText val = findViewById(R.id.txtValor);
        Button botao = findViewById(R.id.btConverter);

        double valor = Double.parseDouble((val).getText().toString());
        double novoValor = 0;

        RadioGroup rg = findViewById(R.id.rgConvert);

        RadioButton radioButton1 = findViewById(R.id.rbRealDolar);
        RadioButton radioButton2 = findViewById(R.id.rbDolarReal);
        RadioButton radioButton3 = findViewById(R.id.rbRealEuro);
        RadioButton radioButton4 = findViewById(R.id.rbEuroReal);
        RadioButton radioButton5 = findViewById(R.id.rbDolarEuro);
        RadioButton radioButton6 = findViewById(R.id.rbEuroDolar);

        if (radioButton1.isChecked())
            novoValor = valor * 0.308;
        if (radioButton2.isChecked())
            novoValor = valor * 3.242;
        if (radioButton3.isChecked())
            novoValor = valor * 0.251;
        if (radioButton4.isChecked())
            novoValor = valor * 3.987;
        if (radioButton5.isChecked())
            novoValor = valor * 0.813;
        if (radioButton6.isChecked())
            novoValor = valor * 1.230;

        DecimalFormat df = new DecimalFormat("0.##");
        String dx = df.format(novoValor);

        AlertDialog.Builder dialogo = new AlertDialog.Builder(ConversaoMoedasActivity.this);
        dialogo.setTitle("Atenção");
        dialogo.setMessage("Valor convertido: " + dx);
        dialogo.setNeutralButton("OK", null);
        dialogo.show();

    }
}
