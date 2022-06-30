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
    		if (p.getDNI() == (DNI)) {
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
                DNI = Integer.parseInt(JOptionPane.showInputDialog(
                            "Ingrese el DNI del paciente"));
                p = new Paciente(campoNombre.getText(), campoUsuario.getText(), campoApellido.getText(), campoEmail.getText(), Long.parseLong(campoTelefono.getText()), campoDireccion.getText(), Integer.parseInt(campoDNI.getText()), campoClave.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Los datos ingresados no son valido");
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

    public static void main(String[] args) {
        Sistema sistemaPrueba = new Sistema();

        // BEGIN PROVISORIO PARA PRUEBAS
        Medico m1 = new Medico("jperez", "Juan", "Perez", 123, 12345678,
                "clavejperez123");
        sistemaPrueba.addMedico(m1);

        Medico m2 = new Medico("armandobanquitos", "Armando", "Banquitos", 145,
                23456789, "clavebanquitos234");
        sistemaPrueba.addMedico(m2);

        Paciente p1 = new Paciente("Diego", "dieguito10", "Maradona",
                "diegomaradona@gmail.com", 2491234567L, "Segurola y Habana 4310",
                345678910, "clave123");
        sistemaPrueba.addPaciente(p1);

        Turno t1 = new Turno(m1, LocalDateTime.of(2022, 06, 13, 16, 00));
        Turno t2 = new Turno(m2, LocalDateTime.of(2022, 06, 13, 18, 00));
        Turno t3 = new Turno(m1, LocalDateTime.of(2022, 06, 14, 11, 00));
        Turno t4 = new Turno(m2, LocalDateTime.of(2022, 06, 13, 13, 00));
        
        m1.addTurno(t1);
        m1.addTurno(t3);

        sistemaPrueba.addTurno(p1, t1);
        sistemaPrueba.addTurno(p1, t3);
        // END PROVISORIO PARA PRUEBAS
        

        JTextField usuarioField = new JTextField();
        JTextField claveField = new JTextField();
        Object[] inputs = {
            "Usuario:", usuarioField,
            "Clave:", claveField
        };

        Usuario usuarioActual;
        int salir;
        do {
            JOptionPane.showConfirmDialog(null, inputs, "Login",
                    JOptionPane.OK_CANCEL_OPTION);

            usuarioActual = sistemaPrueba.loginMedico(usuarioField.getText(),
                    claveField.getText());

            if (usuarioActual == null) {
                usuarioActual = sistemaPrueba.loginSecretaria(usuarioField.getText(),
                        claveField.getText());
            }
            if (usuarioActual == null) {
                salir = JOptionPane.showConfirmDialog(null,
                        "Usuario o contrasenia incorrecto\n"
                        + "Desea volver a intentar?", "Continuar",
                        JOptionPane.YES_NO_OPTION);
            } else {
                usuarioActual.ejecuto();

                salir = JOptionPane.showConfirmDialog(null,
                        "Desea iniciar una nueva sesion?", "Continuar",
                        JOptionPane.YES_NO_OPTION);
            }
        } while (salir == JOptionPane.YES_OPTION);
    }
}
