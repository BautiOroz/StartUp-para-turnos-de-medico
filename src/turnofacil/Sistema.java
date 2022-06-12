package turnofacil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Sistema {

    private ArrayList<Medico> medicos;
    private ArrayList<Paciente> pacientes;

    public Sistema() {
        medicos = new ArrayList<Medico>();
        pacientes = new ArrayList<Paciente>();
    }
    
    public void addMedico(Medico m) {
        this.medicos.add(m);
    }
    
    public void addPaciente(Paciente p) {
        this.pacientes.add(p);
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
        
        String usuario, clave;
        Usuario usuarioActual;
        int salir;

        do {
            usuario = JOptionPane.showInputDialog("Introduzca su usuario");
            clave = JOptionPane.showInputDialog("Introduzca su clave");

            usuarioActual = sistemaPrueba.loginMedico(usuario, clave);//por ahora solo medico
            if (usuarioActual == null) {
            salir = JOptionPane.showConfirmDialog(null,
                    "Usuario o contrasenia incorrecto\n"
                    + "¿Desea volver a intentar?", "Continuar",
                    JOptionPane.YES_NO_OPTION);
            } else {
                usuarioActual.ejecuto();

                salir = JOptionPane.showConfirmDialog(null,
                        "¿Desea iniciar una nueva sesion?", "Continuar",
                        JOptionPane.YES_NO_OPTION);
            }
        } while (salir == JOptionPane.YES_OPTION);
    }
}
