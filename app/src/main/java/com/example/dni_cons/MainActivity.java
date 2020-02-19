package com.example.dni_cons;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dni_cons.model.PersonaResponse;
import com.example.dni_cons.viewmodel.PersonaConsultaViewModel;
import com.example.dni_cons.adapter.mAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    EditText dniTxt;
    private PersonaConsultaViewModel personaConsultaViewModel;
    private mAdapter mAdapter;
    private Button consultaBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configView();
        personaConsultaViewModel = ViewModelProviders.of(MainActivity.this).get(PersonaConsultaViewModel.class);
        personaConsultaViewModel.getDni().observe(this, new Observer<PersonaResponse>() {
            @Override
            public void onChanged(@Nullable PersonaResponse personaResponse) {

                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                mAdapter = new mAdapter(personaResponse.getDatosPerson());
                //adapter.setList(personaResponse.getDatosPerson());
                rv.setAdapter(mAdapter);}


        });

    }


    private void configView(){
        rv = findViewById(R.id.rv);
        dniTxt = findViewById(R.id.txt_dni);
        consultaBtn = findViewById(R.id.btnM_buscar);

        consultaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Sdni;
                Sdni = dniTxt.getText().toString();
                getList(Sdni);
                dniTxt.setText("");

            }
        });



    }

    public void getList(String dni){
        personaConsultaViewModel.getData(dni);
                /*.observe(this, new Observer<PersonaResponse>() {
                    @Override
                    public void onChanged(PersonaResponse personaResponse) {
                        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        mAdapter = new mAdapter(personaResponse.getDatosPerson());
                        //adapter.setList(personaResponse.getDatosPerson());
                        rv.setAdapter(mAdapter);
                    }
                });*/
    }
}
