package com.example.imc_application;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.Display;

public class DadosPreferencias {
    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;


    private final String NOME_ARQUIVO = "anotacao.preferencias";
    private final String CHAVE_NOME = "nome";
    private final String CHAVE_ALTURA = "altura";
    private final String CHAVE_PESO = "peso";
    private final String CHAVE_IMC = "imc";


    public DadosPreferencias(Context c){
        this.context = c;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, 0);
        editor = preferences.edit();
    }

    // salvar uma anotacao
    public void salvarAnotacao(String anotacao){
        editor.putString(CHAVE_NOME, anotacao);
        editor.commit();
    }


    public void salvarPeso(int peso){
        editor.putInt(CHAVE_PESO,peso);
        editor.commit();
    }
    public void salvarAltura (int altura){
        editor.putInt(CHAVE_ALTURA,altura);
        editor.commit();
    }
    public void salvarIMC(String IMC){
        String display = "Seu Indíce de Massa Corporal é "+IMC;
        editor.putString(CHAVE_IMC, display);
        editor.commit();

    }

    // recuperar anotacao
    public String recuperarAnotacao(){
        return preferences.getString(CHAVE_NOME, "");
    }
    public int recuperarPeso(){
        return preferences.getInt(CHAVE_PESO,0);
    }
    public int recuperarAltura(){
        return preferences.getInt(CHAVE_ALTURA,0);
    }
    public String recuperarIMC(){
        return preferences.getString(CHAVE_IMC,"");
    }

}
