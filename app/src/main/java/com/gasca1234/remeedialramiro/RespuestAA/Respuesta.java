package com.gasca1234.remeedialramiro.RespuestAA;

import java.util.List;

public class Respuesta {
    private List<persona> data;

    public Respuesta(List<persona> data) {
        this.data = data;
    }

    public List<persona> getData() {
        return data;
    }

    public void setData(List<persona> data) {
        this.data = data;
    }
}
