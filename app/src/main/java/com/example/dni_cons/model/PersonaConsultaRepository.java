package com.example.dni_cons.model;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.dni_cons.network.ApiClient;
import com.example.dni_cons.network.RetrofitModule;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonaConsultaRepository {

    MutableLiveData<PersonaResponse> personaResponseMutableLiveData = new MutableLiveData<>();

    public void getData(String dni,MutableLiveData<PersonaResponse> mutablePersona){

        ApiClient apiClient = RetrofitModule.getApiClient().create(ApiClient.class);
        Call<PersonaResponse> personaCall = apiClient.consultaPersona(dni);
        personaCall.enqueue(new Callback<PersonaResponse>() {
            @Override
            public void onResponse(Call<PersonaResponse> call, Response<PersonaResponse> response) {
                if (response.isSuccessful() && response.body().getDatosPerson() != null){
                   // personaResponseMutableLiveData.setValue(new PersonaResponse(response.body().getDatosPerson(),null));
                    mutablePersona.setValue(new PersonaResponse(response.body().getDatosPerson(),null));

                    Log.d("dato ok",String.valueOf(mutablePersona.getValue().getDatosPerson().size()));
                }else {
                   // personaResponseMutableLiveData.setValue(new PersonaResponse(null,new Exception("Error en la carga")));
                    mutablePersona.setValue(new PersonaResponse(null,new Exception("Error en la carga")));
                    Log.d("dato",mutablePersona.getValue().toString());
                }
            }
            @Override
            public void onFailure(Call<PersonaResponse> call, Throwable t) {
                mutablePersona.setValue(new PersonaResponse(null,new Exception(t)));
                Log.d("dato",mutablePersona.getValue().toString());
            }
        });

    }
}
