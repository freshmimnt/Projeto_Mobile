package pt.iade.projetomobile.lazuli.models;

public class Curso {

    private int id;

    private String name;

    public Curso(){

    }

    public Curso(int id, String name) {
        this.id = id;
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
}
