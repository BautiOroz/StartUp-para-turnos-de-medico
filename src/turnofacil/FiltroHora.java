package turnofacil;


import javax.swing.JOptionPane;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FiltroHora implements Filtro {
    private LocalTime hora;

    public FiltroHora() {
        hora = cargarHora();
    }

    private LocalTime cargarHora(){
        LocalTime hora = null;
        boolean pudo = true;

        do {
            pudo = true;
            try {
                String date = JOptionPane.showInputDialog(null,
                        "Ingrese la hora en la que quiere buscar (HH:mm)", "Cargar Hora",3);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
                hora = LocalTime.parse("01/01/0001 "+date+":00", formatter);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se ingreso una hora valida", "Warning", 2);
                pudo = false;
            }
        } while (!pudo);

        return hora;
    }

    public LocalTime getHora() {
        return hora;
    }

    @Override
    public boolean cumple(Turno t) {
        return t.getFecha().toLocalTime().equals(hora);
    }
}
