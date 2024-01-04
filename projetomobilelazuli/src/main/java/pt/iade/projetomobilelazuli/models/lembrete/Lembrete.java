package pt.iade.projetomobilelazuli.models.lembrete;


import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @Column(name = "lemb_hora")
    private LocalTime time;

    @Column(name = "lemb_desc")
    private String desc;

    @Column(name = "is_finished")
    private boolean isFinished;

    @ManyToOne
    @JoinColumn(name = "lemb_agen_id", referencedColumnName = "agen_id")
    private Agenda agenda;

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

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public UC getUc() {
        return uc;
    }

    public void setUc(UC uc) {
        this.uc = uc;
    }
}
