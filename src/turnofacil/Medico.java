package turnofacil;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

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
    private static Interfaz interfazMedicos; // falta implementar en el constructor?

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
			i = Integer.parseInt(JOptionPane.showInputDialog("Desea ingresar filtros:   (1)Turnos antes del Mediodia   (2)"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ingreso una opcion valida");
		}
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
		int i = this.interfazMedicos.MostrarOpciones();
		switch(i) {
			case 1: this.DevolverTurnos(); // recorrer turnos y crear filtros.
		}
	}
}    
