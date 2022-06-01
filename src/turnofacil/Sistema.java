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
	 Medico b = medicos.get(medicos.indexOf(m));  //creo medico auxliar y lo copio al medico de la lista que es igual al que ingreso el usuario
	 													//atravez del indexof encuentro la pos del objeto
	 b.addTurno(t);		//agrego el turno al medico de la lista
	 medicos.remove(medicos.indexOf(m));	//borro el medico para no duplicarlo
	 medicos.add(b);	//agrego a la lista
	 Paciente e = pacientes.get(pacientes.indexOf(p));
	 e.addTurno(t);
	 pacientes.remove(pacientes.indexOf(p));
	 pacientes.add(e); 
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
