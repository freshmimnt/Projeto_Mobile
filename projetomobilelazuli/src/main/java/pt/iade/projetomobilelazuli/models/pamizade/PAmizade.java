package pt.iade.projetomobilelazuli.models.pamizade;

import jakarta.persistence.*;
import pt.iade.projetomobilelazuli.models.agenda.Agenda;
import pt.iade.projetomobilelazuli.models.contacto.Contacto;

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

    public PAmizade(){}

    public PAmizade(int id, int contId, Contacto contacto) {
        this.id = id;
        this.contId = contId;
        this.contacto = contacto;
    }


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
}
