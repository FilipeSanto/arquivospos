public class NovaContaActivity extends AppCompatActivity {


	ProgressDialog progressDialog;
	EditText edEmail, edSenha, edNome;
    String email, senha, nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nova_conta);
        etNome = findViewById(R.id.editTextNome2);
        etEmail = findViewById(R.id.editTextEmail2);
        etSenha = findViewById(R.id.editTextSenha2);

        final Button button = findViewById(R.id.buttonCad);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                nome = edtNome.getText().toString();
                email = edtEmail.getText().toString();
                senha = edtSenha.getText().toString();

                cadastrar(nome, email, senha);
            }
        });
    }

    ProgressDialog progressDialog;
    static String TAG = NovaContaActivity.class.getName();

    private void cadastrar(){

        final String url = "http://ec2-34-230-46-185.compute-1.amazonaws.com:8080/v1/users/";
        final RequestQueue queue = Volley.newRequestQueue(this);
        JSONObject postRequest = new JSONObject();

        try {
            postRequest.put("userName", nome);
            postRequest.put("email", email);
            postRequest.put("pass", senha);
            //postRequest.put("appid","4fa74572c6b3268a6ae5bd1150d7a748");

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

                        progressDialog.dismiss();
                        Log.d(TAG, "API Response: " + response);
                        String message = response.optString("sucess");
                        if(message.equals("true")){
                            initiateActivity();
                        }else{
                            AlertDialog dialog = new AlertDialog.Builder(NewAccountActivity.this).create();
                            dialog.setMessage("haahaha");
                            dialog.show();
                        }
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
        progressDialog = new ProgressDialog(NewAccountActivity.this);
        progressDialog.setMessage("Por favor, aguarde");
        progressDialog.show();
    }

    private void initiateActivity(){
        Intent intent = new Intent(this, PrincipalActivity.class);
        startActivity(intent);
    }
}





