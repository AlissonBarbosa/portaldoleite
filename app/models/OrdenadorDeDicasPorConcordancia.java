package models;

import java.util.Collections;
import java.util.List;

public class OrdenadorDeDicasPorConcordancia extends OrdenadorDeDicas {

	private List<Dica> dicas;

	public void ordenaDicas() {
		if(this.tipoDeOrdenacao == "concordancia") {
			Collections.sort(dicas); //muda a ordem do array para o contrario se quiser pegar os mais discordados
		}
	}
}