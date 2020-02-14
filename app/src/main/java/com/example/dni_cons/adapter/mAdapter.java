package com.example.dni_cons.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dni_cons.R;
import com.example.dni_cons.model.Persona;

import java.util.List;

public class mAdapter extends RecyclerView.Adapter<mAdapter.ViewHolder> {

    //private List<Persona> personas = new ArrayList<>();
    private List<Persona> personas;

    public mAdapter(List<Persona> personas) {
        this.personas = personas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_rv,parent,false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.dni.setText(personas.get(position).getDni());
        holder.apP.setText(personas.get(position).getApp());
        holder.apM.setText(personas.get(position).getApem());
        holder.nombres.setText(personas.get(position).getNombre());
        holder.fechaN.setText(personas.get(position).getFechan());
    }
    @Override
    public int getItemCount() {
        return personas.size();
    }

    /*
    public void setList(List<Persona> personas){
        this.personas=personas;
        notifyDataSetChanged();
    } */

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView dni, apP, apM, nombres,fechaN;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dni = itemView.findViewById(R.id.model_lista_txtDni);
            apP = itemView.findViewById(R.id.model_lista_txtApellidoP);
            apM = itemView.findViewById(R.id.model_lista_txtApellidoM);
            nombres = itemView.findViewById(R.id.model_lista_txtNombres);
            fechaN = itemView.findViewById(R.id.model_lista_txtFechaN);
        }
    }

}