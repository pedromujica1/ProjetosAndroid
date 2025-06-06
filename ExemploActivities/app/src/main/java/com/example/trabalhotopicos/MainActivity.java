package com.example.trabalhotopicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonEnviar;
    private TextView textNome;
    private TextView textEmail;
    private TextView textIdade;
    private TextView textEndereco;
    private TextView textTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEnviar = findViewById(R.id.buttonEnviar);
        textNome = findViewById(R.id.viewEmail);
        textEmail = findViewById(R.id.textEmail);
        textIdade = findViewById(R.id.textIdade);
        textEndereco = findViewById(R.id.textEndereco);
        textTelefone = findViewById(R.id.textTelefone);


        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String nome = textNome.getText().toString();
                String email = textEmail.getText().toString();
                String idade_str = textIdade.getText().toString();
                int idade = Integer.parseInt(idade_str);
                String endereco = textEndereco.getText().toString();
                String telefone = textTelefone.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SegundaActivity.class);

                //Cadastrando o usuario na classe
                Usuario usuario = new Usuario(nome,email,idade,telefone,endereco);

                //settando intent
                intent.putExtra("dados_usuario", usuario);

                startActivity(intent);
            }
        });
    }
}