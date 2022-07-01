package turnofacil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class FiltroFecha implements Filtro {
    private LocalDate fecha;

    public FiltroFecha(String s) {
        fecha = cargarFecha(s);
    }

    public FiltroFecha() {
        this("en");
    }

    private LocalDate cargarFecha(String s){
        LocalDate fecha = null;
        boolean pudo = true;

        do {
            pudo = true;
            try {
                String date = JOptionPane.showInputDialog(null,
                        "Ingrese la fecha " + s + " la que quiere buscar (dd/mm/yyyy)", "Cargar Fecha",3);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                fecha = LocalDate.parse(date, formatter);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se ingreso una fecha valida","Warning", 2);
                pudo = false;
            }
        } while (!pudo);

        return fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public boolean cumple(Turno t) {
        return t.getFecha().toLocalDate().equals(fecha);
    }
}
