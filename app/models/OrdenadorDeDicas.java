package models;

public abstract class OrdenadorDeDicas {
	
	String tipoDeOrdenacao;
	
	public String getTipoDeOrdenacao() {
		return tipoDeOrdenacao;
	}

	public void setTipoDeOrdenacao(String tipoDeOrdenacao) {
		this.tipoDeOrdenacao = tipoDeOrdenacao;
	}

	public abstract void ordenaDicas();
}
