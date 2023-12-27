package pt.iade.projetomobilelazuli.models.uc;

import jakarta.persistence.*;
import pt.iade.projetomobilelazuli.models.agenda.Agenda;
import pt.iade.projetomobilelazuli.models.curso.Curso;
import pt.iade.projetomobilelazuli.models.user.Utilizador;

import java.time.LocalDateTime;

@Entity
@Table(name = "UC")
public class UC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UC_id")
    private int id;

    @Column(name = "UC_name")
    private String name;

    @Column(name = "UC_sala")
    private String sala;

    @Column(name = "UC_prof")
    private String prof;

    @Column(name = "UC_desc")
    private String desc;

    @Column(name = "media_nota")
    private String nota;

    @Column(name = "UC_cour_id")
    private int courId;

    @ManyToOne
    @JoinColumn(name = "UC_cour_id", referencedColumnName = "cour_id" )
    private Curso curso;

    @Column(name = "UC_user_id")
    private int userId;

    @ManyToOne
    @JoinColumn(name = "UC_user_id", referencedColumnName = "user_id" )
    private Utilizador utilizador;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {this.nota = nota;}

    public int getCourId() {return courId;}

    public Curso getCurso() {return curso;}

    public void setCurso(Curso curso) {
        this.curso = curso;
        this.courId = curso.getId();
    }

    public int getUserId() {return userId;}

    public Utilizador getUtilizador() {return utilizador;}

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
        this.userId = utilizador.getId();
    }
}
