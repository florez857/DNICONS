package com.example.dni_cons.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.dni_cons.di.Injector;
import com.example.dni_cons.model.PersonaConsultaRepository;
import com.example.dni_cons.model.PersonaResponse;

public class PersonaConsultaViewModel extends ViewModel {

    private PersonaConsultaRepository personaConsRepository = Injector.getInstance().providePersonaConsRepository();

    private MutableLiveData<PersonaResponse> persona=null;


    public PersonaConsultaViewModel(){
            persona=new MutableLiveData<PersonaResponse>();
    }


    public LiveData<PersonaResponse> getDni(){
        return persona;
    }

    public void  getData(String dni){
          personaConsRepository.getData(dni,persona);
           // Log.d("dato",persona.getValue().toString());

    }
}
