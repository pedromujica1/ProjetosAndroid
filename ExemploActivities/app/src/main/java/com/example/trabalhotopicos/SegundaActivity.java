package com.example.trabalhotopicos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;


import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {
    private TextView viewNome, viewEmail,viewIdade,viewTelefone,viewEndereco;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        viewNome = findViewById(R.id.viewNome);
        viewEmail = findViewById(R.id.viewEmail);
        viewEndereco = findViewById(R.id.viewEndereco);
        viewIdade = findViewById(R.id.viewIdade);
        viewTelefone = findViewById(R.id.viewTelefone);



        // recuperar os dados enviados a activity main
        Bundle dados = getIntent().getExtras();

        Usuario usuario = (Usuario) dados.getSerializable("dados_usuario");

        //mostrando dados na tela
        viewNome.setText("Nome: "+usuario.getNome());
        viewEmail.setText("Email: "+usuario.getEmail());
        viewTelefone.setText("Telefone: "+usuario.getTelefone());
        viewEndereco.setText("Endereço: "+usuario.getEndereco());
        viewIdade.setText("Usuario: "+usuario.getIdade());

    }
}