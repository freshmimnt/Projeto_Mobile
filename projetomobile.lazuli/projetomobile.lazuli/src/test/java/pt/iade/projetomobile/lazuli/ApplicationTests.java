package pt.iade.projetomobile.lazuli;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pt.iade.projetomobile.lazuli.models.agenda.Agenda;
import pt.iade.projetomobile.lazuli.models.agenda.AgendaDao;
import pt.iade.projetomobile.lazuli.models.agenda.AgendaRepository;
import pt.iade.projetomobile.lazuli.models.curso.Curso;
import pt.iade.projetomobile.lazuli.models.curso.CursoDao;

import pt.iade.projetomobile.lazuli.models.evento.Evento;
import pt.iade.projetomobile.lazuli.models.evento.EventoDao;
import pt.iade.projetomobile.lazuli.models.evento.EventoRepository;
import pt.iade.projetomobile.lazuli.models.lembrete.Lembrete;
import pt.iade.projetomobile.lazuli.models.lembrete.LembreteDao;
import pt.iade.projetomobile.lazuli.models.tarefa.Tarefa;
import pt.iade.projetomobile.lazuli.models.tarefa.TarefaDao;
import pt.iade.projetomobile.lazuli.models.teste.Teste;
import pt.iade.projetomobile.lazuli.models.teste.TesteDao;
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

	@Autowired
	private TarefaDao tarefaDao;

	@Autowired
	private TesteDao testeDao;

	@Autowired
	private EventoDao eventoDao;


	/*@Test
	void addUtilizadorTeste() {
		Utilizador utilizador = new Utilizador();
		utilizador.setName("Martim");
		utilizador.setEmail("martim@gmail.com");
		utilizador.setPassword("senha6998");
		utilizador.setTurma("T02");
		utilizador.setUserSemestre("2º");
		utilizadorDao.save(utilizador);
	}*/

	/*@Test
	void deleteUserTeste(){
		utilizador = utilizadorRepository.findById(3);
		utilizadorDao.delete(utilizador);
	}*/


	/*@Test
	void addCursoTeste(){
		Curso curso = new Curso();
		curso.setName("Informática de Gestão");
		cursoDao.save(curso);
	}*/

	/*@Test
	void addAgendaTeste(){
		utilizador = utilizadorRepository.findById(4);
		Agenda agenda = new Agenda();
		agenda.setName("Agenda 1");
		agenda.setUtilizador(utilizador);
		agendaDao.save(agenda);
	}*/

	/*@Test
	void addLembreteTeste(){
		agenda = agendaRepository.findById(2);
		Lembrete lembrete = new Lembrete();
		lembrete.setName("Algo");
		lembrete.setDateTime(LocalDateTime.now());
		lembrete.setDesc("INcrivel");
		lembrete.setFinished(false);
		lembrete.setAgenda(agenda);
		lembreteDao.save(lembrete);
	}*/

	/*@Test
	void addTarefaTeste(){
		agenda = agendaRepository.findById(1);
		Tarefa tarefa = new Tarefa();
		tarefa.setName("Projeto Final");
		tarefa.setDateTime(LocalDateTime.of(2023, 12, 10, 18, 0, 0));
		tarefa.setNota("10.5");
		tarefa.setDesc("Entregar o projeto final de Metodologia de Investigação");
		tarefa.setFinished(true);
		tarefa.setAgenda(agenda);
		tarefaDao.save(tarefa);
	}*/

	/*@Test
	void addTesteTeste(){
		agenda = agendaRepository.findById(1);
		Teste teste = new Teste();
		teste.setName("Prova de BD");
		teste.setDateTime(LocalDateTime.now());
		teste.setNota("20");
		teste.setDesc("Algo Generico");
		teste.setFinished(false);
		teste.setAgenda(agenda);
		testeDao.save(teste);
	}*/

	/*@Test
	void addEventoTeste(){
		utilizador = utilizadorRepository.findById(2);
		Evento evento = new Evento();
		evento.setName("Grupo de Estudo");
		evento.setDateTime(LocalDateTime.now());
		evento.setParti(20);
		evento.setDesc("Algo");
		evento.setFinished(true);
		evento.setUtilizador(utilizador);
		eventoDao.save(evento);

	}*/


}
