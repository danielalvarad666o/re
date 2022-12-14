package com.gasca1234.remeedialramiro.AdaptadorPersona;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.gasca1234.remeedialramiro.R;
import com.gasca1234.remeedialramiro.RespuestAA.persona;

import java.util.ArrayList;
import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.Viewholder> {
    private List<persona> personaList;
    private Context context;

    public Adaptador(List<persona> personaList, Context context) {
        this.personaList = personaList;
        this.context = context;
    }

    public Adaptador(List<persona>personaList){this.personaList = personaList;}

    @NonNull
    @Override
    public Adaptador.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.reciclerview,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.Viewholder holder, int position) {
     //   holder.setData(personaList.get(position));
        holder.telefono.setText(personaList.get(position).getNumero());
        holder.nombre.setText(personaList.get(position).getNombre());
        holder.url.setText(personaList.get(position).getUrl());
        holder.personas=(personaList.get(position));
    }

    @Override
    public int getItemCount() {
        return personaList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
    public TextView nombre,url,telefono;
    persona personas;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            nombre=(TextView) itemView.findViewById(R.id.textView);
            url=(TextView) itemView.findViewById(R.id.textView3);
            telefono=(TextView) itemView.findViewById(R.id.textView4);

            url.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    itemView.getContext().startActivity(personas.web());
                }
            });


telefono.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        llamar();
    }

    private void llamar() {
        String phone = "tel:" + telefono.getText();
        if (ContextCompat.checkSelfPermission(itemView.getContext(),
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) itemView.getContext(),
                    new String[]{Manifest.permission.CALL_PHONE}, 255);
        } else {
            String dial = phone;
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(dial));
            itemView.getContext().startActivity(intent);
        }
    }
});
        }


    }
}
