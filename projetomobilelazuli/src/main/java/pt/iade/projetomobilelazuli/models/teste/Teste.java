package pt.iade.projetomobilelazuli.models.teste;

import jakarta.persistence.*;
import pt.iade.projetomobilelazuli.models.agenda.Agenda;

import java.time.LocalDateTime;

@Entity
@Table(name = "Teste")
public class Teste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private int id;

    @Column(name = "test_name")
    private String name;

    @Column(name = "test_date")
    private LocalDateTime dateTime;

    @Column(name = "test_nota")
    private String nota;

    @Column(name = "test_desc")
    private String desc;

    @Column(name = "is_finished")
    private boolean isFinished;

    @Column(name = "test_agend_id")
    private int agendId;

    @ManyToOne
    @JoinColumn(name = "test_agen_id", referencedColumnName = "agen_id" )
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
