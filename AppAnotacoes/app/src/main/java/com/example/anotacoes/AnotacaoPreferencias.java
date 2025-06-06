package com.example.anotacoes;

import android.content.Context;
import android.content.SharedPreferences;


public class AnotacaoPreferencias {

    private Context context;

    private SharedPreferences preferences;

    private SharedPreferences.Editor editor;

    private final String NOME_ARQUIVO = "anotacao.preferencias";

    private final String CHAVE_NOME = "nome";

    //Construtor
    public AnotacaoPreferencias(Context c){
        this.context = c;
        preferences = context.getSharedPreferences(NOME_ARQUIVO,0);
        editor = preferences.edit();

    }

    //Salvar uma anotacao
    public void salvarAnotacao(String anotacao){
        editor.putString(CHAVE_NOME,recuperarAnotacao());
        editor.commit();

    }
    //Recuperar uma anotacao
    public String recuperarAnotacao(){
        return preferences.getString(CHAVE_NOME,"");
    }

    //


}
