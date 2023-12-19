package pt.iade.projetomobile.lazuli.models.user;

import jakarta.persistence.*;

@Entity
@Table(name = "Utilizador")
public class Utilizador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_password", length = 20)
    private String password;

    @Column(name = "user_tur", length = 20)
    private String turma;

    @Column(name = "user_semestre", length = 30)
    private String userSemestre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUserSemestre() {
        return userSemestre;
    }

    public void setUserSemestre(String userSemestre) {
        this.userSemestre = userSemestre;
    }



}
