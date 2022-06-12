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
            i = Integer.parseInt(JOptionPane.showInputDialog(
                        "Desea ingresar filtros:\n     (0)Sin filtros   \n     "
                        + "(1)Turnos antes del Mediodia  \n     "
                        + "(2)Turnos despues del Mediodia  \n     "
                        + "(3)Turnos por rango de fechas"));
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
        return "Medico{" + ", nombre=" + getNombre() +
            ", apellido=" + getApellido() + ", matricula=" + matricula +
            ", DNI=" + getDNI() + ", especialidad=" + listarEspecialidad() +
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
        int i;

        do {
            i = interfazMedicos.mostrarOpciones();
            switch(i) {
                case 0:
                    salir = true;
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, imprimirTurnos());
                    break;
            }
        } while (!salir);
    }
}
