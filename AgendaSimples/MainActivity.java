package com.example.aulatop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aulatop.R;
import com.example.aulatop.adapter.Adapter;
import com.example.aulatop.model.Compromisso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Compromisso> listaCompromissos = new ArrayList<>();
    public TextView idTitulo;
    public TextView idLocal;
    public TextView idNome;
    public TextView idData;
    public TextView idHorario;

    public void criarCompromissos(){
        Compromisso compromisso = new Compromisso("Almoço", "Black House", "17/08", "12:05");
        this.listaCompromissos.add(compromisso);

        compromisso = new Compromisso("Treinar", "Gym", "18/08", "18:40");
        this.listaCompromissos.add(compromisso);

        compromisso = new Compromisso("Aula", "IF", "tds dias", "7:30");
        this.listaCompromissos.add(compromisso);

        compromisso = new Compromisso("Trabalho", "Mundo 365", "Segunda, Quarta e Sexta", "13:30");
        this.listaCompromissos.add(compromisso);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        idTitulo = findViewById(R.id.idTitulo);
        idData = findViewById(R.id.idData);
        idHorario = findViewById(R.id.idHorario);
        idLocal = findViewById(R.id.idLocal);

        //listar os filmes
        this.criarCompromissos();

        //Configurar adapter
        Adapter adapter = new Adapter(listaCompromissos);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter); //criar adapter

        // evento click
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Compromisso compromisso = listaCompromissos.get(position);
                        Toast.makeText(
                                getApplicationContext(),
                                "Local: " + compromisso.getLocal(),
                                Toast.LENGTH_SHORT
                        ).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Compromisso compromisso = listaCompromissos.get(position);
                        Toast.makeText(
                                getApplicationContext(),
                                "Local: " + compromisso.getLocal(),
                                Toast.LENGTH_LONG
                        ).show();
                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }
        ));
    }
    public void cadastro (View view){
        String titulo = idTitulo.getText().toString();
        String local = idLocal.getText().toString();
        String data = idData.getText().toString();
        String horario = idHorario.getText().toString();

        //cadastrando na lista
        Compromisso compromisso = new Compromisso(titulo, local, data, horario);
        this.listaCompromissos.add(compromisso);

        Adapter adapter = new Adapter(listaCompromissos);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter); //criar adapter




    }

}


