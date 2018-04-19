package com.example.filipe.trabalhofinal;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Filipe on 07/04/2018.
 */

public class NovaContaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nova_conta);
        cadastrar();
    }

    ProgressDialog progressDialog;
    static String TAG = NovaContaActivity.class.getName();

    private void cadastrar(){

        final String url = "http://ec2-34-230-46-185.compute-1.amazonaws.com:8080/v1/users/";
        final RequestQueue queue = Volley.newRequestQueue(this);
        final EditText EtNome = findViewById(R.id.editTextNome2);
        EditText teste = EtNome;
        final String nome = teste.getText().toString();
        final EditText EtEmail = findViewById(R.id.editTextEmail2);
        final EditText EtSenha = findViewById(R.id.editTextSenha2);
        final Button button3 = findViewById(R.id.buttonCad);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastro();

        }

        /*if (message.EqualsIgnoreCase("true") {*/
            /*Intent intent = new Intent(NovaContaActivity.this, MainActivity.class);
            startActivity(intent);*/
     /*   }*/

     private void cadastro(){

            JSONObject postRequest = new JSONObject();



            try {

                postRequest.put("userName", teste);
                showDialog("nome: ", teste);
                postRequest.put("email", EtEmail);
                postRequest.put("pass", EtSenha);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                    Request.Method.POST,
                    url,
                    postRequest,
                    new Response.Listener<JSONObject>() {

                        /* Callback chamado em caso de sucesso */

                        @Override
                        public void onResponse(JSONObject response) {

                            /*progressDialog.dismiss();*/
                            Log.d(TAG, "API Response: " + response);
                            String message = response.optString("sucess");
                            showDialog("Informação", message);

                        }
                    },

                    /* Callback chamado em caso de erro */

                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Log.e(TAG, "Ocorreu um erro ao chamar a API " + error);
                            progressDialog.dismiss();
                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    //add params <key,value>
                    return params;
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {

                    Map<String, String> headers = new HashMap<String, String>();
                    String auth = "Basic MzgxNTc5ZmEtZDI0MC00Mzg3LTkyNTMtZWY2YjgwYTdhMWEwOmM4NDM4M2Y0LTJiMDgtNGJiYy04MjQwLWI0YjQ5YTFlYWQzZQ==";
                    headers.put("Authorization", auth);
                    return headers;
                }
            };

            queue.add(jsonObjReq);
            showProgressDialog();
        }

        private void showProgressDialog() {
            ProgressDialog progressDialog = new ProgressDialog(NovaContaActivity.this);
            progressDialog.setMessage("Por favor, aguarde");
            progressDialog.show();
        }

        private void showDialog(String title, String message) {
            AlertDialog alertDialog = new AlertDialog.Builder(NovaContaActivity.this).create();
            alertDialog.setTitle(title);
            alertDialog.setMessage(message);
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }

      });
}
}





