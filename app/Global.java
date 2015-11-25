import java.util.ArrayList;
import java.util.List;
import models.DicaAssunto;
import models.DicaConselho;
import models.DicaDisciplina;
import models.DicaMaterial;
import models.DicaDisciplina;
import models.DicaConselho;
import models.Dica;
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
	private Disciplina si1 = new Disciplina("Sistemas de Informação 1");
	private Disciplina eda = new Disciplina("Estrutuda de Dados");
	private Disciplina p2 = new Disciplina("Programação II");

	@Override
	public void onStart(Application app) {
		Logger.info("AplicaÃ§Ã£o inicializada...");

		JPA.withTransaction(new play.libs.F.Callback0() {
			@Override
			public void invoke() throws Throwable {
				if(dao.findAllByClassName(Disciplina.class.getName()).size() == 0){
					criaDisciplinaTemas();
				}
				addUsuario();
				addDica();
			}
		});
	}
	
	@Override
	public void onStop(Application app){
	    JPA.withTransaction(new play.libs.F.Callback0() {
	    @Override
	    public void invoke() throws Throwable {
	        Logger.info("AplicaÃ§Ã£o finalizando...");
	        disciplinas = dao.findAllByClassName("Disciplina");

	        for (Disciplina disciplina: disciplinas) {
	        dao.removeById(Disciplina.class, disciplina.getId());
	       } 
	    }}); 
	}
	
	private void criaDisciplinaTemas(){
		Disciplina si1 = new Disciplina("Sistemas de InformaÃ§Ã£o 1");
		si1.addTema(new Tema("AnÃ¡lise x Design"));
		si1.addTema(new Tema("OrientaÃ§Ã£o a objetos"));
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
		
		si1.getTemaByNome("Labs").addDica(new DicaConselho("Melhor começar o quanto antes."));
		dao.persist(si1);

		Disciplina eda = new Disciplina("Estrutuda de Dados");
		eda.addTema(new Tema("NotaÃ§Ã£o AssintÃ³tica"));
		eda.addTema(new Tema("AnÃ¡lise de Algoritmos Recursivos"));
		eda.addTema(new Tema("OrdenaÃ§Ã£o por comparaÃ§Ã£o"));
		eda.addTema(new Tema("OrdenaÃ§Ã£o por tempo linear"));
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
		eda.addTema(new Tema("Ã�rvores"));

		eda.getTemaByNome("HEAPS").addDica(new DicaMaterial("http://pages.cs.wisc.edu/~paton/readings/Old/fall01/HEAP-SORT.htm"));
		eda.getTemaByNome("Skip List").addDica(new DicaMaterial("https://www.quora.com/What-uses-are-there-for-Skip-Lists"));

		dao.persist(eda);

		Disciplina p2 = new Disciplina("ProgramaÃ§Ã£o II");
		p2.addTema(new Tema("IntroduÃ§Ã£o a Java"));
		p2.addTema(new Tema("IntroduÃ§Ã£o a OO"));
		p2.addTema(new Tema("CriaÃ§Ã£o de Classes"));
		p2.addTema(new Tema("Introdução a Java"));
		p2.addTema(new Tema("Introdução a OO"));
		p2.addTema(new Tema("Criação de Classes"));
		p2.addTema(new Tema("Testes de unidade"));
		p2.addTema(new Tema("ColeÃ§Ãµes"));
		p2.addTema(new Tema("Reuso, ComposiÃ§Ã£o e HeranÃ§a"));
		p2.addTema(new Tema("HeranÃ§a e polimorfismo"));
		p2.addTema(new Tema("Interfaces e polimorfismo"));
		p2.addTema(new Tema("Tratamento de erros e exceÃ§Ãµes"));
		p2.addTema(new Tema("Recursividade"));
		
		p2.getTemaByNome("HeranÃ§a e polimorfismo").addDica(new DicaAssunto("É útil para padrões de projeto."));
		p2.getTemaByNome("Testes de unidade").addDica(new DicaConselho("Importante para os seus colegas entenderem a funcionalidade do seu código."));
		
		dao.persist(p2);
		
		dao.flush();
	}

	private void addUsuario(){
		User usuario1 = new User("antonio@nsa.com", "antonio123", "antonio");
		usuario1.setNome("Antonio");
		dao.persist(usuario1);

		User usuario2 = new User("carlos@nsa.com", "carlos123", "carlos");
		usuario2.setNome("Carlos");
		dao.persist(usuario2);

		User usuario3 = new User("maria@nsa.com", "maria123", "maria");
		usuario3.setNome("Maria");
		dao.persist(usuario3);

		User usuario4 = new User("mariana@nsa.com", "mariana123", "mariana");
		usuario4.setNome("Mariana");
		dao.persist(usuario4);

		User usuario5 = new User("andre@nsa.com", "andre123", "andre");
		usuario5.setNome("Andre");
		dao.persist(usuario5);

		User usuario6 = new User("ironman@nsa.com", "ironman123", "ironman");
		usuario6.setNome("IronMan");
		dao.persist(usuario6);

		User usuario7 = new User("batman@nsa.com", "batman123", "batman");
		usuario7.setNome("Batman");
		dao.persist(usuario7);

		User usuario8 = new User("hulk@nsa.com", "hulk123", "hulk");
		usuario8.setNome("Hulk");
		dao.persist(usuario8);

		User usuario9 = new User("fenix@nsa.com", "fenix123", "fenix");
		usuario9.setNome("Fenix");
		dao.persist(usuario9);

		User usuario10 = new User("tux@nsa.com", "tux123", "tux");
		usuario10.setNome("The Penguin");
		dao.persist(usuario10);
	}

	private void addDica(){

	}
}
