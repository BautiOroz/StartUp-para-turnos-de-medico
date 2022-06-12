package turnofacil;

import javax.swing.JOptionPane;

public class InterfazMedicos implements Interfaz{
    public int mostrarOpciones() {
        int i = 0;
        boolean pudo = true;

        do {
            pudo = true;
            try {
                i = Integer.parseInt(JOptionPane.showInputDialog(
                            "Ingrese la opcion a ejecutar:\n(0) Salir\n(1) Listar Turnos"));

                if (i < 0 || i > 1) {
                    throw new Exception();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se ingreso una opcion valida");
                pudo = false;
            } 
        }while (!pudo);
        return i;
    }
}
