package pt.iade.projetomobile.lazuli;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pt.iade.projetomobile.lazuli.models.agenda.Agenda;
import pt.iade.projetomobile.lazuli.models.agenda.AgendaDao;
import pt.iade.projetomobile.lazuli.models.agenda.AgendaRepository;
import pt.iade.projetomobile.lazuli.models.curso.Curso;
import pt.iade.projetomobile.lazuli.models.curso.CursoDao;

import pt.iade.projetomobile.lazuli.models.lembrete.Lembrete;
import pt.iade.projetomobile.lazuli.models.lembrete.LembreteDao;
import pt.iade.projetomobile.lazuli.models.user.Utilizador;
import pt.iade.projetomobile.lazuli.models.user.UtilizadorDao;
import pt.iade.projetomobile.lazuli.models.user.UtilizadorRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private UtilizadorDao utilizadorDao;
	@Autowired
	private UtilizadorRepository utilizadorRepository;

	private Utilizador utilizador;

	@Autowired
	private CursoDao cursoDao;

	@Autowired
	private AgendaDao agendaDao;
	@Autowired
	private AgendaRepository agendaRepository;

	private Agenda agenda;

	@Autowired
	private LembreteDao lembreteDao;


	/*@Test
	void addUtilizadorTeste() {
		Utilizador utilizador = new Utilizador();
		utilizador.setName("Martim");
		utilizador.setEmail("martim@gmail.com");
		utilizador.setPassword("senha6998");
		utilizador.setTurma("T02");
		utilizador.setUserSemestre("2º");
		utilizadorDao.save(utilizador);
	}

	@Test
	void addCursoTeste(){
		Curso curso = new Curso();
		curso.setName("Informática de Gestão");
		cursoDao.save(curso);
	}

	@Test
	void addAgendaTeste(){
		utilizador = utilizadorRepository.findById(4);
		Agenda agenda = new Agenda();
		agenda.setName("Agenda 1");
		agenda.setUtilizador(utilizador);
		agendaDao.save(agenda);
	}*/

	@Test
	void addLembreteTeste(){
		agenda = agendaRepository.findById(2);
		Lembrete lembrete = new Lembrete();
		lembrete.setName("Algo");
		lembrete.setDateTime(LocalDateTime.now());
		lembrete.setDesc("INcrivel");
		lembrete.setFinished(false);
		lembrete.setAgenda(agenda);
		lembreteDao.save(lembrete);
	}

}
