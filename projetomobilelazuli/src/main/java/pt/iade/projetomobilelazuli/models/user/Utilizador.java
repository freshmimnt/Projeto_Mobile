package pt.iade.projetomobilelazuli.models.user;
import jakarta.persistence.*;
import pt.iade.projetomobilelazuli.models.curso.Curso;

@Entity
@Table(name = "Utilizador")
public class Utilizador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private int id;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "user_email", nullable = false)
    private String email;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "user_tur")
    private String turma;

    @Column(name = "user_sem")
    private String semestre;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "user_cour_id", referencedColumnName = "cour_id")
    private Curso curso;

    public Utilizador(){

    }

    public Utilizador(int id, String name, String email, String password, String turma, String semestre, Curso curso) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.turma = turma;
        this.semestre = semestre;
        this.curso = curso;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
