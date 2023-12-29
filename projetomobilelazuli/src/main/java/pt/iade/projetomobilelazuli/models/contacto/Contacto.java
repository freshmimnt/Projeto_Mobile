package pt.iade.projetomobilelazuli.models.contacto;
import jakarta.persistence.*;
import pt.iade.projetomobilelazuli.models.user.Utilizador;

@Entity
@Table(name = "Contacto")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "cont_id")
    private int id;

    @Column(name = "cont_user_id", insertable=false, updatable=false)
    private int userId;

    @ManyToOne
    @JoinColumn(name = "cont_user_id", referencedColumnName = "user_id")
    private Utilizador utilizador;

    @Column(name = "cont_user2_id", insertable=false, updatable=false)
    private int user2Id;

    @ManyToOne
    @JoinColumn(name = "cont_user2_id", referencedColumnName = "user_id")
    private Utilizador utilizador2;

    public Contacto(){

    }

    public Contacto(int id, int userId, int user2Id, Utilizador utilizador){
        this.id = id;
        this.utilizador = utilizador;
        this.utilizador2 = utilizador;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public Utilizador getUserid() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
        this.userId = utilizador.getId();
    }

    public Utilizador getUser2Id() {
        return utilizador2;
    }

    public void setUtilizador2(Utilizador utilizador) {
        this.utilizador2 = utilizador;
        this.user2Id = utilizador2.getId();
    }

    public void setUser2Id(int user2Id) {
        this.user2Id = user2Id;
    }
}
