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
	
	public void addTurno(Paciente p, Turno t) {
		p.addTurno(t);
		t.setPaciente(p);
	}
	
	public void loginMedico(String Usuario, String Clave) {
		Medico M = null;
		for(int i=0; i<medicos.size(); i++) {
			if(Usuario == medicos.get(i).getUsuario())
				M = medicos.get(i);
		}
		if(M.esClave(Clave))
			M.Ejecuto();
	}
}
