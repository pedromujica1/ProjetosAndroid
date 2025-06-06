package com.example.aulatop.model;

public class Compromisso {

    private String tituloCompromisso;
    private String local;
    private String data;
    private String horario;

    public Compromisso(String tituloCompromisso, String local, String data, String horario) {
        this.tituloCompromisso = tituloCompromisso;
        this.local = local;
        this.data = data;
        this.horario = horario;
    }

    public String getTituloCompromisso() {
        return tituloCompromisso;
    }

    public void setTituloCompromisso(String tituloCompromisso) {
        this.tituloCompromisso = tituloCompromisso;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
