package com.example.filipe.cores;

import android.graphics.Color;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class CoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cores);
    }

    public void onClick(View view) {
        RadioButton rb1 = findViewById(R.id.rbBranco);
        RadioButton rb2 = findViewById(R.id.rbAmarelo);
        RadioButton rb3 = findViewById(R.id.rbRosa);
        RadioButton rb4 = findViewById(R.id.rbAzul);
        LinearLayout layout = findViewById(R.id.lCores);
        view = findViewById(R.id.view);

        if (rb1.isChecked()) {
            view.setBackgroundColor(Color.rgb(255, 255, 255));
        }
        if (rb2.isChecked()) {
            view.setBackgroundColor(Color.rgb(255, 255, 0));
        }
        if (rb3.isChecked()) {
            view.setBackgroundColor(Color.rgb(255, 105, 180));
        }
        if (rb4.isChecked()) {
            view.setBackgroundColor(Color.rgb(0, 0, 255));
            
        }
    }
}
