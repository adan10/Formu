package com.example.adan.formu;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.adan.Formu.R;

public class MainChido extends AppCompatActivity {

    private Button envia,prueba;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chido);


        envia = (Button)findViewById(R.id.button);

        envia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainChido.this,Prueba.class);
                    startActivity(intent);

            }
        });

        prueba = (Button)findViewById(R.id.chido);

        prueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainChido.this,Empresa.class);
                startActivity(intent);

            }
        });


    }
}
