package pt.iade.projetomobilelazuli.models.lembrete;


import jakarta.persistence.*;
import pt.iade.projetomobilelazuli.models.agenda.Agenda;
import pt.iade.projetomobilelazuli.models.uc.UC;

import java.time.*;

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
    private LocalDate date;

    @Column(name = "lemb_hora")
    private LocalTime time;

    @Column(name = "lemb_desc")
    private String desc;

    @Column(name = "is_finished")
    private boolean isFinished;

    @Column(name = "lemb_agen_id", insertable=false, updatable=false)
    private int agendId;

    @ManyToOne
    @JoinColumn(name = "lemb_agen_id", referencedColumnName = "agen_id")
    private Agenda agenda;

    @Column(name ="lemb_UC_id", insertable=false, updatable=false)
    private int ucId;

    @ManyToOne
    @JoinColumn(name = "lemb_UC_id", referencedColumnName = "UC_id")
    private UC uc;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
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

    public int getAgendId() {
        return agendId;
    }

    public void setAgendId(int agendId) {
        this.agendId = agendId;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
        this.agendId = agenda.getId();
    }

    public int getUcId() {
        return ucId;
    }

    public void setUcId(int ucId) {
        this.ucId = ucId;
    }

    public UC getUc() {
        return uc;
    }

    public void setUc(UC uc) {

        this.uc = uc;
        this.ucId = uc.getId();
    }
}
