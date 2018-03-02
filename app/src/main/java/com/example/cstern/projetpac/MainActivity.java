package com.example.cstern.projetpac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import static java.lang.System.out;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button buttonplay= findViewById(R.id.btnPlay);
        buttonplay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activity = new Intent (MainActivity.this, Main2Activity.class);
                startActivity(activity);

            }
        });



    }

}
