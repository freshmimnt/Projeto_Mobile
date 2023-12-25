package pt.iade.projetomobilelazuli.models.lembrete;


import jakarta.persistence.*;
import pt.iade.projetomobilelazuli.models.agenda.Agenda;

import java.time.LocalDateTime;

@Entity
@Table(name = "Lembrete")
public class Lembrete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lemb_id", nullable = false)
    private int id;

    @Column(name = "lemb_name")
    private String name;

    @Column(name = "lemb_date")
    private LocalDateTime dateTime;

    @Column(name = "lemb_desc")
    private String desc;

    @Column(name = "is_finished")
    private boolean isFinished;

    @Column(name = "lemb_agen_id", insertable=false, updatable=false)
    private int agendId;

    @ManyToOne
    @JoinColumn(name = "lemb_agen_id", referencedColumnName = "agen_id")
    private Agenda agenda;

    public Lembrete(){}

    public Lembrete(int id, String name, LocalDateTime dateTime,
                    String desc, boolean isFinished, int agendId, Agenda agenda) {
        this.id = id;
        this.name = name;
        this.dateTime = dateTime;
        this.desc = desc;
        this.isFinished = isFinished;
        this.agendId = agendId;
        this.agenda = agenda;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
        this.agendId = agendId;
    }
}
