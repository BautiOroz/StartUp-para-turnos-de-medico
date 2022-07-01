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
        String retorno = "";
        ArrayList<Turno> turnosImp = devolverTurnos(seleccionarFiltro());

        for (Turno t: turnosImp) {
            retorno += t.toString();
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
    
    public ArrayList<Turno> devolverTurnos(Filtro filter) {
        ArrayList<Turno> retorno = new ArrayList<>();
        for (Turno t:turnos) {
            if (filter.cumple(t)) {
                retorno.add(t);
            }
        }
        return retorno;
    }

    private Filtro seleccionarFiltro() {
        int i = 0;
        String[] opciones = {"Sin Filtros", "Turnos antes del Mediodia","Turnos despues del Mediodia", "Turnos por rango de fechas" };
        i = JOptionPane.showOptionDialog(null, "Seleccione la opcion que desee", "Filtros", 0, JOptionPane.QUESTION_MESSAGE, null, opciones, "");

        FiltroAnd filter = new FiltroAnd(new FiltroDisponible(), new FiltroNada());

        switch(i) {
            case 0:
                break;
            case 1: filter.setFiltro2(new FiltroMediodia());
                break;
            case 2: filter.setFiltro2(new FiltroNot(new FiltroMediodia()));
                break;
            case 3: filter.setFiltro2(new FiltroRangoDias());
                break;
        }
        return filter;
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
                    JOptionPane.showMessageDialog(null, imprimirTurnos(),"Turnos",1);
                    break;
            }
        } while (!salir);
    }
}
