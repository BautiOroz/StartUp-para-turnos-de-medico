package turnofacil;

public class FiltroRangoHorario implements Filtro{
    private static final int hora= 12;
    
    public boolean cumple(Turno t) {
        return t.getFecha().getHour() <= hora;
    }
}
