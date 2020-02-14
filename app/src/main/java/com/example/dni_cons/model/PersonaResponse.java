package com.example.dni_cons.model;

import java.util.List;

public class PersonaResponse {

    private List<Persona> DatosPerson;
    private Exception exception;

    public PersonaResponse(List<Persona> datosPerson, Exception exception) {
        this.DatosPerson = datosPerson;
        this.exception = exception;
    }

    public List<Persona> getDatosPerson() {
        return DatosPerson;
    }

    public void setDatosPerson(List<Persona> datosPerson) {
        DatosPerson = datosPerson;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

}
