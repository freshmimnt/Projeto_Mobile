package pt.iade.projetomobilelazuli.models.teste;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import pt.iade.projetomobilelazuli.models.agenda.Agenda;
import pt.iade.projetomobilelazuli.models.uc.UC;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Teste")
public class Teste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id", nullable = false)
    private int id;

    @Column(name = "test_name", nullable = false)
    private String name;

    @Column(name = "test_data", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @Column(name = "test_hora", nullable = false)
    private LocalTime time;

    @Column(name = "test_nota")
    private String nota;

    @Column(name = "test_desc")
    private String desc;

    @Column(name = "is_finished", nullable = false)
    private boolean isFinished;

    @Column(name = "test_agen_id", insertable=false, updatable=false)
    private int agendId;

    @ManyToOne
    @JoinColumn(name = "test_agen_id", referencedColumnName = "agen_id" )
    private Agenda agenda;

    @Column(name = "test_UC_id", insertable=false, updatable=false)
    private int ucId;

    @ManyToOne
    @JoinColumn(name = "test_UC_id", referencedColumnName = "UC_id")
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
