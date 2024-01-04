package pt.iade.projetomobile.lazuli.models;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class UCItem implements Serializable{

    private int id;
    private String nome;
    private String sala;
    private String prof;
    private String desc;
    private Curso curso;
    private User user;

    public UCItem(){
        this(0, "","","","");
    }

    public UCItem(int id, String nome, String sala, String prof, String desc){
        this.id = id;
        this.nome = nome;
        this.sala = sala;
        this.prof = prof;
        this.desc = desc;
    }

    public static ArrayList<UCItem> List(){
        ArrayList<UCItem> items = new ArrayList<UCItem>();
        return items;
    }

    public static UCItem GetById(int id){
        return new UCItem(id,"","","","");
    }

    public void save(){
        if(id == 0){
            id = new Random().nextInt(1000) + 1;
        }else{

        }
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUcName() {
        return nome;
    }

    @NonNull
    @Override
    public String toString(){
        return nome;
    }



}
