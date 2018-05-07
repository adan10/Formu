package com.example.adan.formu;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.adan.Formu.R;


public class Emp2 extends AppCompatActivity {

    NotificationCompat.Builder nBuilder;
public  static final int Notificacion_ID=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp2);
    }

    public void onclick(View view){
        Intent intent = new Intent(Emp2.this,Empleado.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.plomero);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setContentTitle("Funciona plsss");
            builder.setContentText("EL contenido");
            builder.setSubText("El perro texto");


        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(Notificacion_ID,builder.build());
    }
}
