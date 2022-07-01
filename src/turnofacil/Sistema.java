package turnofacil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Sistema {

    private ArrayList<Medico> medicos;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Secretaria> secretarias;

    public Sistema() {
        medicos = new ArrayList<Medico>();
        pacientes = new ArrayList<Paciente>();
        secretarias = new ArrayList<Secretaria>();
    }
    
    public void addMedico(Medico m) {
        this.medicos.add(m);
    }
    
    public void addPaciente(Paciente p) {
        this.pacientes.add(p);
    }

    public void addSecretaria(Secretaria s) {
        this.secretarias.add(s);
    }
    
    public void addTurno(Paciente p, Turno t) {
        p.addTurno(t);
        t.setPaciente(p);
    }
    
    public Medico loginMedico(String usuario, String clave) {
        Medico m = null;

        for(int i=0; i<medicos.size(); i++) {
            if(medicos.get(i).getUsuario().equals(usuario)) {
                m = medicos.get(i);
            }
        }

        if(m != null && m.esClave(clave)) {
            return m;
        }
        else {
            return null;
        }
    }
    
    public Paciente getPaciente(int DNI) {
    	for (Paciente p:pacientes) {
    		if (p.getDNI() == DNI) {
    			return p;
    		}
    	}
    	return null;
    }
    
    public Paciente registrarPaciente() {
    	String nombre; 
    	String usuario; 
    	String apellido; 
    	String email;
        long telefono; 
        String direccion; 
        int DNI; 
        String clave;
        
        JTextField campoNombre = new JTextField();
        JTextField campoUsuario = new JTextField();
        JTextField campoApellido = new JTextField();
        JTextField campoEmail = new JTextField();
        JTextField campoTelefono = new JTextField();
        JTextField campoDireccion = new JTextField();
        JTextField campoDNI = new JTextField();
        JTextField campoClave = new JTextField();
        
        Paciente p = null;
        
        Object[] campos = {
        		"Nombre", campoNombre,
        		"Apellido", campoApellido,
        		"DNI", campoDNI,
        		"Usuario", campoUsuario,
        		"Clave", campoClave,
        		"Email", campoEmail,
        		"Telefono", campoTelefono,
        		"Direccion", campoDireccion
        };
        
        do{
            try {
            	JOptionPane.showConfirmDialog(null, campos, "Registro de Paciente", JOptionPane.OK_OPTION);
                p = new Paciente(campoNombre.getText(), campoUsuario.getText(), campoApellido.getText(), campoEmail.getText(), Long.parseLong(campoTelefono.getText()), campoDireccion.getText(), Integer.parseInt(campoDNI.getText()), campoClave.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Los datos ingresados no son validos","Warning", 2);
            }
        }while (p == null);
        
        addPaciente(p);
        return p;
    }

    public Secretaria loginSecretaria(String usuario, String clave) {
        Secretaria m = null;

        for(int i=0; i<secretarias.size(); i++) {
            if(secretarias.get(i).getUsuario().equals(usuario)) {
                m = secretarias.get(i);
            }
        }

        if(m != null && m.esClave(clave)) {
            return m;
        }
        else {
            return null;
        }
    }
}
