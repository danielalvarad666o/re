package com.gasca1234.remeedialramiro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.RecoverySystem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.gasca1234.remeedialramiro.AdaptadorPersona.Adaptador;
import com.gasca1234.remeedialramiro.RespuestAA.Respuesta;
import com.gasca1234.remeedialramiro.RespuestAA.persona;
import com.gasca1234.remeedialramiro.Sigleton.SingletonRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Adaptador adaptador;
List<Respuesta> respuestaList;
List<persona> personaList;

private RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQueue = SingletonRequest.getInstance(MainActivity.this).getRequestQueue();
        respuestaList = new ArrayList<>();
        personaList = new ArrayList<>();
        jsparse();
    }

    private void jsparse() {
        String url="https://ramiro.uttics.com/api/contactos";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                RecyclerView recyclerView = findViewById(R.id.recycler);
                int duration = Toast.LENGTH_SHORT;
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                Gson gson = new Gson();
                Respuesta pk = gson.fromJson(response.toString(), Respuesta.class);
                adaptador = new Adaptador(pk.getData());
                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();

                recyclerView.setAdapter(adaptador);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }
}