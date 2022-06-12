package turnofacil;

import java.util.ArrayList;
import java.util.Objects;

import javax.swing.JOptionPane;

public class Medico {
    private final String usuario;
    private final String nombre;
    private final String apellido;
    private final int matricula;
    private final int DNI;
    private String clave;
    private ArrayList<String> especialidad;
    private ArrayList<Turno> turnos;
    private ArrayList<String> obraSocial;
    private static InterfazMedicos interfazMedicos = new InterfazMedicos();

    public Medico(String usuario, String nombre, String apellido, int matricula, int DNI, String clave) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.DNI = DNI;
        this.clave = clave;
        especialidad = new ArrayList<>();
        turnos = new ArrayList<>();
        obraSocial = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getMatricula() {
        return matricula;
    }

    public int getDNI() {
        return DNI;
    }

    public void addEspecialidad(String especialidad){
        this.especialidad.add(especialidad);
    }

    public void addTurno(Turno turno){
        this.turnos.add(turno);
    }

    public void addObraSocial(String obraSocial){
        this.obraSocial.add(obraSocial);
    }

    public boolean esClave(String clave){
        return (this.clave == clave); 
    }

    public String getUsuario() {
		return usuario;
	}

	public boolean esEspecialista(String especialidad){
        return this.especialidad.contains(especialidad);
    }

    public boolean trabajaObraSocial(String obraSocial){
        return this.obraSocial.contains(obraSocial);
    }
    
    public String imprimirTurnos() {
    	String retorno = "Turnos: \n";
    	ArrayList<Turno> turnosImp = this.devolverTurnos();
    	for (Turno t: turnosImp) {
    		retorno += "          " + t.toString();
			retorno += "\n";
    	}
    	return retorno;
    }
    
    public String listarEspecialidad(){
        String lista = "";
        for (String especialidad : this.especialidad) {
            lista += especialidad + ", ";
        }
        return lista;
    }

    public String listarObraSocial(){
        String lista = "";
        for (String obraSocial : this.obraSocial) {
            lista += obraSocial + ", ";
        }
        return lista;
    }
    
    public ArrayList<Turno> devolverTurnos() {
    	int i = 0;
    	try {
			i = Integer.parseInt(JOptionPane.showInputDialog("Desea ingresar filtros:\n     (0)Sin filtros   \n     (1)Turnos antes del Mediodia  \n     (2)Turnos despues del Mediodia  \n     (3)Turnos por rango de fechas"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ingreso una opcion valida");
		}
    	FiltroAnd filter = new FiltroAnd(new FiltroDisponible(), new FiltroNada());
    	switch(i) {
    		case 0:
    			break;
    		case 1: filter.setFiltro2(new FiltroRangoHorario());
    			break;
    		case 2: filter.setFiltro2(new FiltroNot(new FiltroRangoHorario()));
				break;
    		case 3: filter.setFiltro2(new FiltroRangoDias());
    			break;
    	}
    	ArrayList<Turno> retorno = new ArrayList<>();
    	for (Turno t:turnos) {
    		if (filter.cumple(t)) {
    			retorno.add(t);
    		}
    	}
    	return retorno;
    }
    
    @Override
    public String toString() {
        return "Medico{" + ", nombre=" + nombre +
            ", apellido=" + apellido + ", matricula=" + matricula +
            ", DNI=" + DNI + ", especialidad=" + listarEspecialidad() +
            ", obraSocial=" + listarObraSocial() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        try {
            Medico otro = (Medico) o;
            return this.getMatricula() == otro.getMatricula();
        } catch (Exception e){
            return false;
        }
    }
	
	public void Ejecuto() {
		int i = interfazMedicos.MostrarOpciones();
		switch(i) {
			case 1:
				String imprimirTurnos = this.imprimirTurnos();
				JOptionPane.showMessageDialog(null, imprimirTurnos);
				break;
		}
	}
}    
