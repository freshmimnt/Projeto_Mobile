package pt.iade.projetomobilelazuli.models.ue;

import jakarta.persistence.*;
import jdk.jshell.execution.Util;
import pt.iade.projetomobilelazuli.models.curso.Curso;
import pt.iade.projetomobilelazuli.models.evento.Evento;
import pt.iade.projetomobilelazuli.models.user.Utilizador;

@Entity
@Table(name = "UE")
public class UE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UE_id", nullable = false)
    private int id;

    @Column(name = "UE_even_id", insertable=false, updatable=false)
    private int evenId;

    @ManyToOne
    @JoinColumn(name = "UE_even_id", referencedColumnName = "even_id")
    private Evento evento;

    @Column(name = "UE_user_id", insertable=false, updatable=false)
    private int userId;

    @ManyToOne
    @JoinColumn(name = "UE_user_id", referencedColumnName = "user_id")
    private Utilizador utilizador;

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

    public int getUserId() {
        return userId;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
        this.userId = utilizador.getId();
    }
}
