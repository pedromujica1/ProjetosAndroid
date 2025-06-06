package com.example.anotacoes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


    private AnotacaoPreferencias preferencias;

    private EditText editAnotacao;

    private Button buttonSalvar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAnotacao = findViewById(R.id.editAnotacao);
        buttonSalvar = findViewById(R.id.buttonSalvar);

        preferencias = new AnotacaoPreferencias(getApplication());

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //VALIDAR SE O USUARIO DIGITOU ALGO
                String textoRecuperado = editAnotacao.getText().toString();

                if (textoRecuperado.equals("")){
                    Snackbar.make(view,"PREENCHA A ANOTAÇÃO",Snackbar.LENGTH_LONG).show();
                }else{
                    preferencias.salvarAnotacao(textoRecuperado);
                    Snackbar.make(view,"ANOTAÇÃO SALVA COM SUCESSO",Snackbar.LENGTH_LONG).show();
                }

            }
        });

        //RECUPERAR INFORMAÇÃO
        String anotacao = preferencias.recuperarAnotacao();
        if (!anotacao.equals("")){
            editAnotacao.setText(anotacao);
        }


    }
}