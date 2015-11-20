import java.util.ArrayList;
import java.util.List;

import models.User;
import models.Disciplina;
import models.Tema;
import models.dao.GenericDAOImpl;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.db.jpa.JPA;


public class Global extends GlobalSettings {

	private static GenericDAOImpl dao = new GenericDAOImpl();
	private List<Disciplina> disciplinas = new ArrayList<>();
	
	@Override
	public void onStart(Application app) {
		Logger.info("Aplicação inicializada...");

		JPA.withTransaction(new play.libs.F.Callback0() {
			@Override
			public void invoke() throws Throwable {
				if(dao.findAllByClassName(Disciplina.class.getName()).size() == 0){
					criaDisciplinaTemas();
				}
				addUsuario();
			}
		});
	}
	
	@Override
	public void onStop(Application app){
	    JPA.withTransaction(new play.libs.F.Callback0() {
	    @Override
	    public void invoke() throws Throwable {
	        Logger.info("Aplicação finalizando...");
	        disciplinas = dao.findAllByClassName("Disciplina");

	        for (Disciplina disciplina: disciplinas) {
	        dao.removeById(Disciplina.class, disciplina.getId());
	       } 
	    }}); 
	}
	
	private void criaDisciplinaTemas(){
		Disciplina si1 = new Disciplina("Sistemas de Informação 1");
		si1.addTema(new Tema("Análise x Design"));
		si1.addTema(new Tema("Orientação a objetos"));
		si1.addTema(new Tema("GRASP"));
		si1.addTema(new Tema("GoF"));
		si1.addTema(new Tema("Arquitetura"));
		si1.addTema(new Tema("Play"));
		si1.addTema(new Tema("JavaScript"));
		si1.addTema(new Tema("HTML / CSS / Bootstrap"));
		si1.addTema(new Tema("Heroku"));
		si1.addTema(new Tema("Labs"));
		si1.addTema(new Tema("Minitestes"));
		si1.addTema(new Tema("Projeto"));
		dao.persist(si1);
		Disciplina eda = new Disciplina("Estrutuda de Dados");
		eda.addTema(new Tema("Notação Assintótica"));
		eda.addTema(new Tema("Análise de Algoritmos Recursivos"));
		eda.addTema(new Tema("Ordenação por comparação"));
		eda.addTema(new Tema("Ordenação por tempo linear"));
		eda.addTema(new Tema("TAD"));
		eda.addTema(new Tema("Listas encadeadas"));
		eda.addTema(new Tema("ABP"));
		eda.addTema(new Tema("HEAPS"));
		eda.addTema(new Tema("Skip List"));
		eda.addTema(new Tema("Tabela Hash"));
		eda.addTema(new Tema("AVL"));
		eda.addTema(new Tema("Árvores"));
		dao.persist(eda);
		Disciplina p2 = new Disciplina("Programação II");
		p2.addTema(new Tema("Introdução a Java"));
		p2.addTema(new Tema("Introdução a OO"));
		p2.addTema(new Tema("Criação de Classes"));
		p2.addTema(new Tema("Testes de unidade"));
		p2.addTema(new Tema("Coleções"));
		p2.addTema(new Tema("Reuso, Composição e Herança"));
		p2.addTema(new Tema("Herança e polimorfismo"));
		p2.addTema(new Tema("Interfaces e polimorfismo"));
		p2.addTema(new Tema("Tratamento de erros e exceções"));
		p2.addTema(new Tema("Recursividade"));
		dao.persist(p2);
		dao.flush();
	}

	private void addUsuario(){
		User usuario1 = new User("antonio@nsa.com", "antonio123", "antonio");
		usuario1.setNome("Antonio");
		dao.persist(usuario1);
	}
}
