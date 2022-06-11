package turnofacil;

import javax.swing.JOptionPane;

public class InterfazMedicos implements Interfaz{
	
	public int MostrarOpciones() {
		int i = 0;
		boolean Pudo = true;
		do {
			Pudo = true;
			try {
				i = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion a ejecutar:   (1) Listar Turnos"));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No se ingreso una opcion valida");
				Pudo = false;
			} 
		}while (!Pudo);
		return i;
	}
}
