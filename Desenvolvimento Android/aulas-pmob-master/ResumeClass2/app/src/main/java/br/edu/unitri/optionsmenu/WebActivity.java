package br.edu.unitri.optionsmenu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Exemplo de chamada de uma página Web
 *
 * @author viniciusdepaula
 */

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);
        final Button button = findViewById(R.id.btnCallWebView);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                callWebView();
            }
        });
    }

    /**
     * Faz a chamada ao intent responsável pela abertura de página Web
     *
     */

    private void callWebView() {

        Uri webpage = Uri.parse("http://www.android.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);
    }
}
