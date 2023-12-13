package pt.iade.projetomobile.lazuli.models;

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

    @Column(name = "user_turma", length = 20)
    private String turma;

    @Column(name = "user_semestre", length = 30)
    private String userSemestre;


}
