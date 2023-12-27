package pt.iade.projetomobilelazuli.models.ue;

import jakarta.persistence.*;
import pt.iade.projetomobilelazuli.models.curso.Curso;
import pt.iade.projetomobilelazuli.models.evento.Evento;

@Entity
@Table(name = "UE")
public class UE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UE_id")
    private int id;

    @Column(name = "UE_even_id", insertable=false, updatable=false)
    private int evenId;

    @ManyToOne
    @JoinColumn(name = "UE_even_id", referencedColumnName = "even_id")
    private Evento evento;

    @Column(name = "UE_cour_id", insertable=false, updatable=false)
    private int courId;

    @ManyToOne
    @JoinColumn(name = "UE_cour_id", referencedColumnName = "cour_id")
    private Curso curso;

    public UE(){

    }

    public UE(int id, int evenId, Evento evento, int courId, Curso curso) {
        this.id = id;
        this.evento = evento;
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public int getEvenId() {
        return evenId;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
        this.evenId = evento.getId();
    }

    public int getCourId() {
        return courId;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
        this.courId = curso.getId();
    }
}
