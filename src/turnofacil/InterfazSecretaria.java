package turnofacil;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class InterfazSecretaria implements Interfaz {

    @Override
    public int mostrarOpciones() {
        int i = 0;
        String[] opciones = {"Salir", "Cargar Turno", "Cancelar Turno"};
        i = JOptionPane.showOptionDialog(null, "Elija la opcion a ejecutar", "Menu", 0, JOptionPane.QUESTION_MESSAGE, null, opciones, "");
        return i;
    }

    public boolean existePaciente() {
    	int existe = JOptionPane.showConfirmDialog(null,
                "El paciente posee una cuenta?", "Continuar",
                JOptionPane.YES_NO_OPTION);
        return (existe == JOptionPane.YES_OPTION);
    }
}
