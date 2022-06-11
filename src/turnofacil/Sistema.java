package turnofacil;

import java.util.ArrayList;

public class Sistema {

	private ArrayList<Medico> medicos;
	private ArrayList<Paciente> pacientes;

    public Sistema() {
        medicos = new ArrayList<Medico>();
        pacientes = new ArrayList<Paciente>();
    }
	
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

    public static void main(String[] args) {
        // BEGIN PROVISORIO
        Medico m1 = new Medico("jperez", "Juan", "Perez", 123, 12345678,
                "clavejperez123");
        Medico m2 = new Medico("armandobanquitos", "Armando", "Banquitos", 145,
                23456789, "clavebanquitos234");
    }
}
