package eventos;

public abstract class Compromisso {
	private String data;
	private String local;
	private int duracao;

	
	public Compromisso() {
		data = "";
		local = "";
		duracao = 0;
	}
	
	public Compromisso(String data, String local, int duracao) {
		this.data = data;
		this.local = local;
		this.duracao = duracao;
	}


	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}


	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public abstract void detalhesDoEvento();
}
