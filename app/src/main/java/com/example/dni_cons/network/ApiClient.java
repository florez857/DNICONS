package com.example.dni_cons.network;

import com.example.dni_cons.model.PersonaResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiClient {


    @FormUrlEncoded
    //@POST("postulante_obtenerDatosPostulante.htm")
    @POST("retrofit_listar_reniec.php")
    Call<PersonaResponse> consultaPersona(
            @Field("strDni") String dni
    );
}
