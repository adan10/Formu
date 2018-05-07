package com.example.adan.formu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.adan.Formu.R;

public class Empre extends AppCompatActivity {

    TextView nombre,descrip,hor,ubi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empre);



        iniciar();
    }
    public void iniciar(){
        nombre = findViewById(R.id.Nombre);
        descrip = findViewById(R.id.Descripcion);
        hor = findViewById(R.id.Horario);
        ubi = findViewById(R.id.Ubicacion);

        Bundle ven = getIntent().getExtras();
        String name = ven.getString("nombre");
        String des = ven.getString("descripcion");
        String horario = ven.getString("horario");
        String ubica = ven.getString("ubicacion");
        nombre.setText("Bienvenido "+name);
        descrip.setText("Descripsion: "+des);
        hor.setText("Horario "+horario);
        ubi.setText("Ubicacion "+ubica);

    }
    public void envia(View vw){
        Intent ob = new Intent(Empre.this,Trabajos.class);
        startActivity(ob);
    }
}
