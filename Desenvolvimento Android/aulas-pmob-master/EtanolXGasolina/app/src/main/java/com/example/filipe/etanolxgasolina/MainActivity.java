package com.example.filipe.etanolxgasolina;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.text.DecimalFormat;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculaCombustivel(View view) {

        final EditText val1 = (EditText) findViewById(R.id.etanolTxt);
        final EditText val2 = (EditText) findViewById(R.id.gasolinaTxt);
        Button botao = (Button) findViewById(R.id.btCalcula);
                double valor1 = Double.parseDouble((val1).getText().toString());
                double valor2 = Double.parseDouble((val2).getText().toString());
                double percentual = (valor1/valor2) * 100;
                DecimalFormat df = new DecimalFormat("0.##");
                String dx = df.format(percentual);

                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                dialogo.setTitle("Atenção");
                if (percentual <= 70) {
                    dialogo.setMessage("Percentual: "+ dx + " Abasteça com Etanol");
                } else {
                    dialogo.setMessage("Percentual: "+ dx + " Abasteça com Gasolina");
                }
                dialogo.setNeutralButton("OK", null);
                dialogo.show();

            }
        }



