package com.example.trabalhotopicos;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nome;
    private String email;

    private int idade;

    private String telefone;

    private String endereco;


    //construtor
    public Usuario(String nome, String email, int idade, String telefone, String endereco) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.telefone = telefone;
        this.endereco = endereco;
    }


    public String getIdade() {
        return String.valueOf(idade);
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}