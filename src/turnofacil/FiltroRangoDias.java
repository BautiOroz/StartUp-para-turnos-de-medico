package turnofacil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class FiltroRangoDias implements Filtro{
    private FiltroFecha diaDesde, diaHasta;

    public FiltroRangoDias() {
        diaDesde = new FiltroFecha("desde");
        diaHasta = new FiltroFecha("hasta");
    }

    public boolean cumple(Turno t) {
        return (t.getFecha().toLocalDate().compareTo(diaDesde.getFecha()) >= 0) &&
            (t.getFecha().toLocalDate().compareTo(diaHasta.getFecha()) <= 0);
    }
}
