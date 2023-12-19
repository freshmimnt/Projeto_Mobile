package pt.iade.projetomobile.lazuli;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pt.iade.projetomobile.lazuli.models.user.Utilizador;
import pt.iade.projetomobile.lazuli.models.user.UtilizadorDao;

import java.util.List;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private UtilizadorDao utilizadorDao;

	//@Test
	void addUtilizadorTeste() {
		Utilizador utilizador = new Utilizador();
		utilizador.setName("Joa");
		utilizador.setEmail("joaquim@gmail.com");
		utilizador.setPassword("senha9090");
		utilizador.setTurma("D1");
		utilizador.setUserSemestre("2º");
		utilizadorDao.save(utilizador);
	}

}
