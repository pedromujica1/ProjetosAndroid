package com.example.imc_application;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private DadosPreferencias preferencias;
    private EditText editAnotacao;
    private Button buttonSalvar;

    private TextView textIMC;

    private EditText editPeso;
    private EditText editAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RETIRANDO DADOS DOS COMPONENTES DO XML
        buttonSalvar = findViewById(R.id.buttonSalvar);
        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);
        textIMC = findViewById(R.id.textIMC);

        //INSTANCIANDO A CLASSE DADOS PREFERENCIAS
        preferencias = new DadosPreferencias(getApplication());

        //DEFININDO AÇÃO CASO O BOTÃO FOR CLICADO
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String peso_str = editPeso.getText().toString();
                String altura_str = editAltura.getText().toString();

                int peso = Integer.parseInt(peso_str);
                int altura = Integer.parseInt(altura_str);

                double imc = peso / (Math.pow(altura,2));
                double IMC = Math.round(imc * 100.0)/100.0;

                //VERIFICANDO PREENCHIMENTO DOS DADOS
                if(peso_str.equals("") && altura_str.equals("")){
                    Snackbar.make(view, "Preencha os dados", Snackbar.LENGTH_LONG).show();
                }else {
                    //SALVANDO DADOS NAS PREFERENCIAS
                    String imc_str = String.valueOf(IMC);
                    preferencias.salvarAltura(altura);
                    preferencias.salvarPeso(peso);
                    preferencias.salvarIMC(imc_str);
                    textIMC.setText(imc_str);
                    Snackbar.make(view, "Dados salvos com sucesso!", Snackbar.LENGTH_LONG).show();
                }
            }
        });//FIM DA AÇÃO QUANDO O BOTÃO FOR CLICADO

        //RECUPERANDO INFORMAÇÕES
        int alt_metros = preferencias.recuperarAltura();
        int peso_kg = preferencias.recuperarPeso();
        String imc_valor = preferencias.recuperarIMC();

        //DEFININDO DADOS QUANDO APLICATIVO FOR REINICIADO
        if(!imc_valor.equals("")){
            textIMC.setText(imc_valor);
        }
        if(peso_kg !=0 ){
            editPeso.setText(String.valueOf(peso_kg));
        }
        if(alt_metros !=0 ){
            editAltura.setText(String.valueOf(alt_metros));
        }



    }
}