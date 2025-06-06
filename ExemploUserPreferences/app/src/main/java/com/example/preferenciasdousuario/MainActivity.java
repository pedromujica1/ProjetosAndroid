package com.example.preferenciasdousuario;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private Button buttonSalvar;
    private TextInputEditText editNome;
    private TextView textResultado;

    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Retirando estruturas e dados do XML
        buttonSalvar = findViewById(R.id.buttonSalvar);
        editNome = findViewById(R.id.editNome);
        textResultado = findViewById(R.id.textResultado);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //parametros: nome do arquivo (constante) e mode (somente aplicativo acessa - 0)
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);

                SharedPreferences.Editor editor = preferences.edit();

                //validar nome
                if(editNome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"HELLO THERE, HAHAHAHAHA",Toast.LENGTH_LONG).show();
                }else {
                    String nome = editNome.getText().toString();
                    editor.putString("nome", nome);
                    editor.commit();
                    textResultado.setText("OLÁ, "+nome);
                }

            }
        });

        //Recuperar dados salvos
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
        if (preferences.contains("nome")){
            String nome = preferences.getString("nome","usuário não encontrado");
            textResultado.setText("OLÁ "+nome);

        }
        else{
            textResultado.setText("OLÁ, USUÁRIO NÃO DEFINIDO");
        }

    }
}