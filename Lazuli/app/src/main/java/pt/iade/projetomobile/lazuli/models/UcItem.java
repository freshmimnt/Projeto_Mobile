package pt.iade.projetomobile.lazuli.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
public class UcItem implements Serializable{

    private int id;
    private String name;
    private String professor;
    private String sala;

    private String description;

    public UcItem(){
        this(1,"d","s","e","oio");
    }

    public UcItem(int id, String name, String professor, String sala, String description ){
        this.id = id;
        this.name = name;
        this.professor = professor;
        this.sala = sala;
        this.description = description;
    }

    public static ArrayList<UcItem> List(){
        ArrayList<UcItem> items = new ArrayList<>();
        items.add(new UcItem(1,"F","#","e","dd"));
        return items;
    }

    public static UcItem GetById(int id){

        return new UcItem(id, "nn","mm","KK","ll");
    }

    public void save() {
        // TODO: Send the object's data to our web server and update the database there.

        if (id == 0) {

            id = new Random().nextInt(1000) + 1;

        } else {

        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

