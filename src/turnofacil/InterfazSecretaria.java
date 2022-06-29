package turnofacil;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class InterfazSecretaria implements Interfaz {

    @Override
    public int mostrarOpciones() {
        int i = 0;
        boolean pudo = true;

        do {
            pudo = true;
            try {
                i = Integer.parseInt(JOptionPane.showInputDialog(
                            "Ingrese la opcion a ejecutar:\n(0) Salir\n" +
                            "(1) Cargar Turno\n(2) Cancelar Turno"));

                if (i < 0 || i > 2) {
                    throw new Exception();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se ingreso una opcion valida");
                pudo = false;
            } 
        }while (!pudo);
        return i;
    }

    public boolean existePaciente() {
        return false;
    }
}
