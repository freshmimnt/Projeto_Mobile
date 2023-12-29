package pt.iade.projetomobilelazuli.models.tarefa;

import jakarta.persistence.*;
import pt.iade.projetomobilelazuli.models.agenda.Agenda;

import java.time.LocalDateTime;

@Entity
@Table(name = "Tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tarefa_id")
    private int id;

    @Column(name = "tarefa_name")
    private String name;

    @Column(name = "tarefa_date")
    private LocalDateTime dateTime;

    @Column(name = "tarefa_nota")
    private String nota;

    @Column(name = "tarefa_desc")
    private String desc;

    @Column(name = "is_finished")
    private boolean isFinished;

    @Column(name = "tarefa_agen_id", insertable=false, updatable=false)
    private int agendId;

    @ManyToOne
    @JoinColumn(name = "tarefa_agen_id", referencedColumnName = "agen_id")
    private Agenda agenda;

    public Tarefa(){}

    public Tarefa(int id, String name, LocalDateTime dateTime, String nota,
                  String desc, boolean isFinished, int agendId, Agenda agenda) {
        this.id = id;
        this.name = name;
        this.dateTime = dateTime;
        this.nota = nota;
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

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
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
        this.agendId = agenda.getId();
    }
}
