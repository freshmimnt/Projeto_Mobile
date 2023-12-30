package pt.iade.projetomobilelazuli.models.pamizade;

import jakarta.persistence.*;
import pt.iade.projetomobilelazuli.models.agenda.Agenda;
import pt.iade.projetomobilelazuli.models.contacto.Contacto;
import pt.iade.projetomobilelazuli.models.estado.Estado;

import java.time.LocalDateTime;

@Entity
@Table(name = "PAmizade")
public class PAmizade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PA_id", nullable = false)
    private int id;

    @Column(name = "PA_cont_id", insertable=false, updatable=false)
    private int contId;

    @ManyToOne
    @JoinColumn(name = "PA_cont_id", referencedColumnName = "cont_id")
    private Contacto contacto;

    @Column(name = "PA_stat_id", insertable=false, updatable=false)
    private int statId;

    @ManyToOne
    @JoinColumn(name = "PA_stat_id", referencedColumnName = "stat_id")
    private Estado estado;

    public int getId() {
        return id;
    }

    public int getContId() {
        return contId;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
        this.contId = contId;
    }

    public int getStatId() {
        return statId;
    }

    public Estado getEstado(){ return estado;}

    public void setEstado(Estado estado) {
        this.estado = estado;
        this.statId = statId;
    }
}
