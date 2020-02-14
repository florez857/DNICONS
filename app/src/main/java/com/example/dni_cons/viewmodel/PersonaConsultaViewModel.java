package com.example.dni_cons.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.dni_cons.di.Injector;
import com.example.dni_cons.model.PersonaConsultaRepository;
import com.example.dni_cons.model.PersonaResponse;

public class PersonaConsultaViewModel extends ViewModel {

    private PersonaConsultaRepository personaConsRepository = Injector.getInstance().providePersonaConsRepository();

    public LiveData<PersonaResponse> getData(String dni){
        return personaConsRepository.getData(dni);
    }
}
