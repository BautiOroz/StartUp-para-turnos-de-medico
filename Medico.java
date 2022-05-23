package turnofacil;

import java.util.ArrayList;

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

    public boolean esUsuarioYClave(String usuario, String clave){
        return this.usuario.equals(usuario) && this.clave.equals(clave);
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

    @Override
    public String toString() {
        return "Medico{" + ", nombre=" + nombre +
            ", apellido=" + apellido + ", matricula=" + matricula +
            ", DNI=" + DNI + ", especialidad=" + listarEspecialidad() +
            ", obraSocial=" + listarObraSocial() + '}';
    }
}