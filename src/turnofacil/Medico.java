package turnofacil;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Medico extends Usuario {
    private final int matricula;
    private ArrayList<String> especialidad;
    private ArrayList<Turno> turnos;
    private ArrayList<String> obraSocial;
    private static InterfazMedicos interfazMedicos = new InterfazMedicos();

    public Medico(String usuario, String nombre, String apellido, int matricula, int DNI, String clave) {
        super(usuario, nombre, apellido, DNI, clave);
        this.matricula = matricula;
        especialidad = new ArrayList<>();
        turnos = new ArrayList<>();
        obraSocial = new ArrayList<>();
    }

    public int getMatricula() {
        return matricula;
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

    public boolean esEspecialista(String especialidad){
        return this.especialidad.contains(especialidad);
    }

    public boolean trabajaObraSocial(String obraSocial){
        return this.obraSocial.contains(obraSocial);
    }

    public String listarTurnos(){
        String lista = "";
        for (Turno turno : turnos) {
            if (!turno.estaDisponible()) {
                lista += turno.toString() + "\n";
            }
        }
        return lista;
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
    
    public ArrayList<Turno> DevolverTurnos() {
    	int i = 0;
    	try {
			i = Integer.parseInt(JOptionPane.showInputDialog("Desea ingresar filtros:\n     (0)Sin filtros   \n     (1)Turnos antes del Mediodia  \n     (2)Turnos por rango de fechas"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ingreso una opcion valida");
		}
    	Filtro filter = new FiltroNada();
    	switch(i) {
    		case 0: filter = new FiltroNada();
    			break;
    		case 1: filter = new FiltroRangoHorario();
    			break;
    		case 2: filter = new FiltroRangoDias();
    			break;
    	}
    	ArrayList<Turno> retorno = new ArrayList<>();
    	for (Turno t:turnos) {
    		if (filter.cumple(t)) {
    			retorno.add(t);
    			//JOptionPane.showMessageDialog(null, "Total: " + retorno.size());
    		}
    	}
    	return retorno;
    }
    
    @Override
    public String toString() {
        return "Medico{" + ", nombre=" + this.getNombre() +
            ", apellido=" + this.getApellido() + ", matricula=" + matricula +
            ", DNI=" + this.getDNI() + ", especialidad=" + listarEspecialidad() +
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
    
    public void ejecuto() {
        boolean salir = false;
        do {
            int i = interfazMedicos.mostrarOpciones();
            switch(i) {
                //case 1: this.DevolverTurnos(); // recorrer turnos y crear filtros.
                case 0:
                    salir = true;
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "El medico listo todo");
                    break;
            }
        } while (!salir);
    }
}    
