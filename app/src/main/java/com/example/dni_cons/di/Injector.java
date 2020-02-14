package com.example.dni_cons.di;

import com.example.dni_cons.model.PersonaConsultaRepository;

public class Injector {

    private static Injector injector;
    private PersonaConsultaRepository personaRepository = new PersonaConsultaRepository();


    public static Injector getInstance(){

        if (injector==null)
            injector = new Injector();

        return injector;
    }

    public PersonaConsultaRepository providePersonaConsRepository(){
        return personaRepository;
    }
}
