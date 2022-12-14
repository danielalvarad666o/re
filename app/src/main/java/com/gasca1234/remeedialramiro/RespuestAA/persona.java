package com.gasca1234.remeedialramiro.RespuestAA;

import android.content.Intent;
import android.net.Uri;

import java.net.URL;

public class persona {


        private  String nombre;
        private  String numero;
        private String url;

    public persona(String nombre, String numero, String url) {
        this.nombre = nombre;
        this.numero = numero;
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Intent web ()
    {
        Uri uri=Uri.parse(this.url);return  new Intent(Intent.ACTION_VIEW,uri);
    }

}


