package pt.iade.projetomobile.lazuli.models;

import java.io.Serializable;

public class Evento implements Serializable {
    private int id;
    private String name;
    private int participants;

    public Evento(int id, String name, int participants) {
        this.id = id;
        this.name = name;
        this.participants = participants;
    }

    public Evento(String name, int participants) {
        this(0, name, participants);
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

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }
}
