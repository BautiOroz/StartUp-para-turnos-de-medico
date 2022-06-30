
package turnofacil;

public class APISistema {
	private final Sistema sistema;
	
	public APISistema(Sistema s) {
		this.sistema = s;
	}
	
	public Paciente getPaciente(int DNI) {
		return sistema.getPaciente(DNI);
	}
	
	public Paciente crearPaciente() {
		return sistema.registrarPaciente();	
	}
}
