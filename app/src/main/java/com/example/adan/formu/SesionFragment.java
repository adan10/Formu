package com.example.adan.formu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.example.adan.Formu.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SesionFragment extends Fragment implements Response.Listener<JSONObject>,Response.ErrorListener {

    RequestQueue rq;
    JsonRequest jrq;

    EditText cajaUser,cajaPwd;
    Button btnConsutar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_sesion, container, false);
        View vista= inflater.inflate(R.layout.fragment_sesion,container,false);

        cajaUser =(EditText)vista.findViewById(R.id.txtUsr);

        cajaPwd =(EditText)vista.findViewById(R.id.txtPsw);

         btnConsutar =(Button)vista.findViewById(R.id.btnSesion);
        rq = Volley.newRequestQueue(getContext());


         btnConsutar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 iniciarSesion();
             }
         });

         return vista;
    }


    @Override
    public void onErrorResponse(VolleyError error) {


        Toast.makeText(getContext(),"No se ha encontrado el usuario" +error.toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {

        Toast.makeText(getContext(),"Se ha encontrado el usuario" +cajaUser.getText().toString() ,Toast.LENGTH_SHORT).show();





        User usuario = new User();

        JSONArray jsonArray = response.optJSONArray("datos");
     JSONObject jsonObjec = null;


        try {
            jsonObjec  = jsonArray.getJSONObject(0);

            usuario.setUser(jsonObjec.optString("user"));
            usuario.setPwd(jsonObjec.optString("pwd"));
            usuario.setName(jsonObjec.optString("names"));

        } catch (JSONException e) {
            e.printStackTrace();
        }


        Intent intent = new Intent(getContext(),Main2Activity.class);
    intent.putExtra(Main2Activity.nombres,usuario.getUser());
        startActivity(intent);

    }

    private void iniciarSesion(){


       // https://adan212210.000webhostapp.com
        String url="https://adan212210.000webhostapp.com/sesion.php?user="+cajaUser.getText().toString()+
                "&pwd="+cajaPwd.getText().toString();



        /* String url="http:// 10.184.233.79/login/sesion.php?user="+cajaUser.getText().toString()+"&pwd="+cajaPwd.getText().toString();
*/
        jrq = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        rq.add(jrq);


    }
}