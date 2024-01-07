package pt.iade.projetomobilelazuli.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "Lembrete")
public class Lembrete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lemb_id", nullable = false)
    private int id;

    @Column(name = "lemb_name", nullable = false)
    private String name;

    @Column(name = "lemb_data")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Calendar date;

    @Column(name = "lemb_hora")
    private Date time;

    @Column(name = "lemb_desc")
    private String desc;

    @Column(name = "is_finished")
    private boolean isFinished;

    @ManyToOne
    @JoinColumn(name = "lemb_agen_id", referencedColumnName = "agen_id")
    private Agenda agenda;

    public int getId() {
        return id;
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

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

}
