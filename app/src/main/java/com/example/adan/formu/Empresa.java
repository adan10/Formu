package com.example.adan.formu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.adan.Formu.R;

public class Empresa extends AppCompatActivity {

    EditText nombre,descripcion,horario,ubicacion;
    Button enviar;
    TextView msj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa);

        nombre = findViewById(R.id.Nombre);
        descripcion = findViewById(R.id.Descripcion);
        horario = findViewById(R.id.Horario);
        ubicacion = findViewById(R.id.Ubicacion);
        enviar = findViewById(R.id.Enviar);
      //  msj = findViewById(R.id.mensaje);
    }

    public void envia(View vw){
        if ((valida())) {
            Intent gDatos = new Intent(Empresa.this,Empre.class);
            gDatos.putExtra("nombre",nombre.getText().toString());
            gDatos.putExtra("descripcion",descripcion.getText().toString());
            gDatos.putExtra("horario",horario.getText().toString());
            gDatos.putExtra("ubicacion",ubicacion.getText().toString());


            startActivity(gDatos);
        }
    }

    public boolean valida(){
        if(nombre.getText().toString().equals("")||descripcion.getText().toString().equals("")||horario.getText().toString().equals("")||ubicacion.getText().toString().equals("")){
            nombre.setText("");
            descripcion.setText("");
            horario.setText("");
            ubicacion.setText("");

            return false;
        }else{
            return true;
        }
    }

}
