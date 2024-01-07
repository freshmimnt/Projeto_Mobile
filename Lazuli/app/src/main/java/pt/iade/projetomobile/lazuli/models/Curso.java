package pt.iade.projetomobile.lazuli.models;

import androidx.annotation.NonNull;

public class Curso {

    private int id;

    private String name;

    public Curso(){

    }

    public Curso(int id, String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString(){
        return name;
    }
}
