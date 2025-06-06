package com.example.aulatop.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aulatop.R;
import com.example.aulatop.model.Compromisso;
import com.example.aulatop.model.Compromisso;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Compromisso> listaCompromissos;

    public Adapter(List<Compromisso> lista){
        this.listaCompromissos = lista;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Compromisso compromisso = listaCompromissos.get(position);

        holder.titulo.setText(compromisso.getTituloCompromisso());
        holder.genero.setText(compromisso.getHorario());
        holder.ano.setText(compromisso.getData());
    }

    @Override
    public int getItemCount() {
        return listaCompromissos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titulo;
        TextView ano;
        TextView genero;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);

        }
    }
}