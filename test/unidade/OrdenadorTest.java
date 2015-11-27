package unidade;

import static org.fest.assertions.Assertions.assertThat;

import models.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OrdenadorTest {

	Disciplina disciplina;
	List<Disciplina> disciplinas;
	Tema tema;
	Dica dica1, dica2, dica3, dica4;
	User user;

	@Before
	public void before() {
		disciplinas = new ArrayList<>();
		disciplina = new Disciplina("Álgebra Linear");
		tema = new Tema("teste");

		dica1 = new DicaAssunto("LaPlace");
		dica2 = new DicaConselho("Não subestime a última prova");
		dica3 = new DicaMaterial("https://www.youtube.com/watch?v=NyAp-3QXdC0");
		dica4 = new DicaDisciplina("Álgebra Vetorial", "Pré-requisito importante");

		user = new User("schopenh@uer.com", "lifesucks", "schops");
	}

	@Test
	public void deveTestarOrdemPorInsercao(){
		tema.setDisciplina(disciplina);
		dica1.setTema(tema);

		OrdenadorDeDicasPorInsercao ordenador = new OrdenadorDeDicasPorInsercao();
		ordenador.ordenaDicas(disciplinas);
		assertThat(ordenador.ordenaDicas(disciplinas).isEmpty());
	}

}
