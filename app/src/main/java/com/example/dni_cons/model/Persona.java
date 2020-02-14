package com.example.dni_cons.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Persona {


    @Expose
    @SerializedName("DNI") public String dni;
    @Expose
    @SerializedName("ApellidoPaterno") public String app;
    @Expose
    @SerializedName("ApellidoMaterno") public String apem;
    @Expose
    @SerializedName("Nombres") public String nombre;
    @Expose
    @SerializedName("FechaNacimiento") public String fechan;
    @Expose
    @SerializedName("Sexo") public String Sexo;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getApem() {
        return apem;
    }

    public void setApem(String apem) {
        this.apem = apem;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechan() {
        return fechan;
    }

    public void setFechan(String fechan) {
        this.fechan = fechan;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }
}
