package turnofacil;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Sistema sistemaPrueba = new Sistema();
        APISistema apiPrueba = new APISistema(sistemaPrueba);

        // BEGIN PROVISORIO PARA PRUEBAS
        Secretaria s1 = new Secretaria("claudia_s", "Claudia", "Sanchez", 567891012,
                "claveclaudia456", apiPrueba);
        sistemaPrueba.addSecretaria(s1);

        Medico m1 = new Medico("jperez", "Juan", "Perez", 123, 12345678,
                "clavejperez123");
        sistemaPrueba.addMedico(m1);

        Medico m2 = new Medico("armandobanquitos", "Armando", "Banquitos", 145,
                23456789, "clavebanquitos234");
        sistemaPrueba.addMedico(m2);

        Paciente p1 = new Paciente("Diego", "dieguito10", "Maradona",
                "diegomaradona@gmail.com", 2491234567L, "Segurola y Habana 4310",
                345678, "clave123");
        sistemaPrueba.addPaciente(p1);

        Turno t1 = new Turno(m1, LocalDateTime.of(2022, 06, 13, 16, 00));
        Turno t2 = new Turno(m2, LocalDateTime.of(2022, 06, 13, 18, 00));
        Turno t3 = new Turno(m1, LocalDateTime.of(2022, 06, 14, 11, 00));
        Turno t4 = new Turno(m2, LocalDateTime.of(2022, 06, 13, 13, 00));
        
        sistemaPrueba.addTurno(p1, t1);
        sistemaPrueba.addTurno(p1, t3);
        s1.addMedico(m1);
        s1.addMedico(m2);
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
