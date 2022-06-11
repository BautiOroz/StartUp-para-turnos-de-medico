package turnofacil;

public class FiltroRangoHorario implements Filtro{
	private static final int Hora= 12;
	
	public boolean cumple(Turno t) {
		return t.getFecha().getHour() <= Hora;
	}
}
