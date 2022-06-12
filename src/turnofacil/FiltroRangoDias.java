package turnofacil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class FiltroRangoDias implements Filtro{
    private LocalDate diaDesde;
    private LocalDate diaHasta;

    public FiltroRangoDias() {
        diaDesde = cargarFecha();
        diaHasta = cargarFecha();
    }

    private LocalDate cargarFecha(){
        LocalDate fecha = null;
        boolean pudo = true;

        do {
            pudo = true;
            try {
                String date = JOptionPane.showInputDialog(
                        "Ingrese la fecha desde la que quiere buscar (dd/mm/yyyy)");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                fecha = LocalDate.parse(date, formatter);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se ingreso una fecha valida");
                pudo = false;
            }
        } while (!pudo);

        return fecha;
    }

    public boolean cumple(Turno t) {
        return (t.getFecha().toLocalDate().compareTo(diaDesde) >= 0) &&
            (t.getFecha().toLocalDate().compareTo(diaHasta) <= 0);
    }
}
