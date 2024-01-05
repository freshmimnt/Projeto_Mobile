package pt.iade.projetomobile.lazuli.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class LembreteItem implements Serializable {

    private int id;

    private String name;

    private Calendar date;

    private Date time;

    private String desc;

    private boolean isFinished;

    private Agenda agenda;

    public LembreteItem(){

    }

    public LembreteItem(int id, boolean isFinished, String name, Calendar date,
                        Date time, String desc) {
        this.id = id;
        this.isFinished = isFinished;
        this.name = name;
        this.date = date;
        this.time = time;
        this.desc = desc;
    }

    public static ArrayList<LembreteItem> List(){

        ArrayList<LembreteItem> items = new ArrayList<>();
        items.add(new LembreteItem(3, false,"Arroz", new GregorianCalendar(), new Date(), "Algo"));

        return items;
    }

    public static LembreteItem GetById(int id){
        return new LembreteItem(id, false, "Alloy", new GregorianCalendar(), new Date(), "Shine");

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

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        this.isFinished = finished;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

}
