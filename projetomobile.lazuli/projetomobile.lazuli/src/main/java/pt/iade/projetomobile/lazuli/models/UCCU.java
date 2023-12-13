package pt.iade.projetomobile.lazuli.models;
import jakarta.persistence.*;

@Entity
@Table(name = "uccu")
public class UCCU {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uccu_id")
    private int id;

    @Column(name = "uccu_ucc_id")
    private int ucc_id;

    @Column(name = "uccu_user_id")
    private int user_id;

}
