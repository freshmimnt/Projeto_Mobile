package pt.iade.projetomobile.lazuli.models;

import java.util.Calendar;
import java.util.Date;

public class LembreteItem {

    private int id;
    private boolean done;
    private String title;

    private Calendar date;

    private Date time;

    private String description;

    private Agenda agenda;

    public LembreteItem(){

    }

    public LembreteItem(int id, boolean done, String title, Calendar date,
                        Date time, String description, Agenda agenda) {
        this.id = id;
        this.done = done;
        this.title = title;
        this.date = date;
        this.time = time;
        this.description = description;
        this.agenda = agenda;
    }

    public int getId() {
        return id;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

}
