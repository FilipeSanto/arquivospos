package br.edu.unitri.optionsmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);
        final Button button = findViewById(R.id.btnCallEmailClient);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                callEmailClient();
            }
        });
    }

    /**
     * Faz a chamada ao intent responsável pela abertura de página Web
     *
     */

    private void callEmailClient() {

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"viniciusdpaula@gmail.com"}); // recipients
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Este é o assunto do email");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Aqui vai o corpo do email");
        startActivity(emailIntent);
    }
}
