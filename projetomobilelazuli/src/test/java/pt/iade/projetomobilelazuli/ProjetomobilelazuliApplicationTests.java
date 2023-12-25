package pt.iade.projetomobilelazuli;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pt.iade.projetomobilelazuli.models.user.Utilizador;
import pt.iade.projetomobilelazuli.models.user.UtilizadorDao;
import pt.iade.projetomobilelazuli.models.user.UtilizadorRepository;

@SpringBootTest
class ProjetomobilelazuliApplicationTests {

	@Autowired
	private UtilizadorDao utilizadorDao;
	@Autowired
	private UtilizadorRepository utilizadorRepository;

	private Utilizador utilizador;

	/*@Test
	void addUtilizadorTeste() {
		Utilizador utilizador = new Utilizador();
		utilizador.setName("Lola");
		utilizador.setEmail("lolita@gmail.com");
		utilizador.setPassword("senha6998");
		utilizador.setTurma("T02");
		utilizador.setSemestre("3º");
		utilizadorDao.save(utilizador);
	}*/

	@Test
	void deleteUserTeste(){
		utilizador = utilizadorRepository.findById(6);
		utilizadorDao.delete(utilizador);
	}

}
