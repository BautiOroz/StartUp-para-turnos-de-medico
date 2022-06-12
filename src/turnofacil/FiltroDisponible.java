package turnofacil;

public class FiltroDisponible implements Filtro{
	
	public boolean cumple(Turno t) {
		return !t.estaDisponible();
	}
}
