package pt.iade.projetomobile.lazuli.modules;

import java.io.Serializable;

public class Evento implements Serializable {
    private int id;
    private String title;
    private int participants;

    public Evento(int id, String title, int participants) {
        this.id = id;
        this.title = title;
        this.participants = participants;
    }

    public Evento(String title, int participants) {
        this(0, title, participants);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }
}
