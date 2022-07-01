package turnofacil;

import javax.swing.JOptionPane;

public class InterfazMedicos implements Interfaz{
    public int mostrarOpciones() {
        int i = 0;
        String[] opciones = {"Salir", "Listar Turnos"};
        i = JOptionPane.showOptionDialog(null, "Elija la opcion a ejecutar", "Menu", 0, JOptionPane.QUESTION_MESSAGE, null, opciones, "");
        return i;
    }
}
