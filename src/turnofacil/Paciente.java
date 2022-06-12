package turnofacil;
import java.util.ArrayList;

public class Paciente extends Usuario {

    private String email;
    private long telefono;
    private String direccion;
    private ArrayList<Turno> turnos;
    private ArrayList<String> obraSocial;
    
   public Paciente(String nombre, String usuario, String apellido, String email,
            long telefono, String direccion, int DNI, String clave) {
        super(usuario, nombre, apellido, DNI, clave);
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.turnos = new ArrayList<>();
        this.obraSocial = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public long getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void addTurno(Turno t) {
        this.turnos.add(t);
    }
    public void addObraSocial(String os) {
    if (this.obraSocial.contains(os))
        this.obraSocial.add(os);
    }
    
    public String listarTurno() {
    
        return "a"; // listo los turnos.
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        try {
            Paciente otro = (Paciente) o;
            return this.getDNI() == otro.getDNI();
        } catch (Exception e){
            return false;
        }
    }

	public void ejecuto() {
        // implemtenar ejecuto
	}
}
