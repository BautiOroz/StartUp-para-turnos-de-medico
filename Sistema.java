package turnofacil;

import java.time.LocalDate;
import java.util.ArrayList;

public class Sistema {

	private ArrayList<Medico> medicos;
	private ArrayList<Paciente> pacientes;
	
	public void addMedico(Medico m) {
		this.medicos.add(m);
	}
	
	public void addPaciente(Paciente p) {
		this.pacientes.add(p);
	}
	
	public void addTurno(Medico m,Paciente p, LocalDate fecha) {
	 Turno t = new Turno( 0,m, fecha);
	 m.addTurno(t); // revisar (arreglar)
	 p.addTurno(t);
	}
	
	public boolean loginMedico(String Usuario, String Clave) {
			//craer codigo
		return true;
	}
}
