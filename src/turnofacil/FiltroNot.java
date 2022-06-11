package turnofacil;

public class FiltroNot implements Filtro {
	private Filtro filtro1; 
	
	public FiltroNot(Filtro f) {
		this.filtro1 = f;
	}
	
	public void setFiltro(Filtro f) {
		this.filtro1= f;
	}
	
	public Filtro getFiltro() {
		return filtro1;
	}
	
	public boolean cumple(Turno t) {
		return !filtro1.cumple(t);
	}
}
