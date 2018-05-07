package com.example.adan.formu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.adan.Formu.R;

public class Empleado extends AppCompatActivity {



    Button empre, empre2, empre3,Favo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleado);


        empre = (Button)findViewById(R.id.button5);

        empre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Empleado.this, Emp2.class);
                startActivity(intent);
            }
        });


        empre2 = (Button)findViewById(R.id.button2);
        empre2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Empleado.this, Emp3.class);
                startActivity(intent);
            }
        });

        empre3 = (Button)findViewById(R.id.button4);
        empre3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Empleado.this, Emp4.class);
                startActivity(intent);
            }
        });

        Favo = (Button)findViewById(R.id.Favoritos);
        Favo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Empleado.this, Favoritos.class);
                startActivity(intent);
            }
        });



    }
}
