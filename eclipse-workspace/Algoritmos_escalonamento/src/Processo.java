
public class Processo {
	
	private String id;
	private int tempo_exe;
	private int tempo_sub;
	private int tempo_bloq;
	private int prior;
	private Integer esta_bloq = null;
	
	
	public Processo(String id, int tempo_sub, int prior,  int tempo_exe, int tempo_bloq) {
		this.id = id;
		this.tempo_sub = tempo_sub;
		this.prior = prior;
		this.tempo_bloq = tempo_bloq;
		this.tempo_exe = tempo_exe;
	}
	
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id)  {
		this.id = id;
	}
	
	public int getSub() {
		return (this.tempo_sub);
	}
	
	public void setSub(int sub) {
		this.tempo_sub = sub;
	}
	
	public int getBloc() {
		return (this.tempo_bloq);
	}
	
	public void setBloc(int b) {
		this.tempo_bloq = b;
	}
	
	public int getEx() {
		return (this.tempo_exe);
	}
	
	public void setEx(int e) {
		this.tempo_exe = e;
	}
	
	public int getPri() {
		return (this.prior);
	}
	
	public void setPri(int p) {
		this.prior = p;
	}
	
	
	/*
	 * Método verifica se está bloqueado
	 */
	
	public Boolean isBloq(Integer p) {
		return (esta_bloq.compareTo(p))>=0;
	}
	
	public Integer getBloq() {
		return this.esta_bloq;
	}
	
}
