package turnofacil;

import java.util.ArrayList;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Secretaria extends Usuario {
    private ArrayList<Medico> medicos;
    private static InterfazSecretaria interfazSecretaria = new InterfazSecretaria();
    private final APISistema system;

    public Secretaria(String usuario, String nombre, String apellido, int DNI,
            String clave, APISistema s) {
        super(usuario, nombre, apellido, DNI, clave);
        this.medicos = new ArrayList<>();
        this.system = s;
    }

    public void addMedico(Medico m) {
        if (!medicos.contains(m)) {
            medicos.add(m);
        }
    }

    public void removeMedico(Medico m) {
        if (medicos.contains(m)) {
            medicos.remove(m);
        }
    }

    public boolean trabajaCon(Medico m) {
        return medicos.contains(m);
    }

    private Medico getMedico(int matricula) {
        for (Medico m : medicos) {
            if (m.getMatricula() == matricula) {
                return m;
            }
        }
        return null;
    }

    public void cargarTurno(Paciente p) {
        Turno t ;
        int salir;
        String paso;
        
        do {
            t = getTurno();
            if ((!(t == null) && !(t.estaDisponible()) || (t == null))) {
            	if (!(t == null)) {
            		paso = "El turno no esta disponible";
            	} else {
            		paso = "No se encontro un turno para los datos ingresados";
            	}
            	
                salir = JOptionPane.showConfirmDialog(null,
                    paso + ", desea buscar uno nuevo?",
                    "Continuar", JOptionPane.YES_NO_OPTION);
            } else {
                salir = JOptionPane.NO_OPTION;
            }
        } while (salir == JOptionPane.YES_OPTION);

        if (!(t == null) && t.estaDisponible()) {
        	t.setPaciente(p);
        	JOptionPane.showMessageDialog(null, "El turno se cargo con exito");
        }
    }
    
    private Paciente getPaciente() {
        boolean existe = interfazSecretaria.existePaciente();
        Paciente p = null;
        int DNI;
        if (existe) {
        	 do{
                 try {
                     DNI = Integer.parseInt(JOptionPane.showInputDialog(null,
                                 "Ingrese el DNI del paciente", "Buscar Paciente", 3));
                     p = system.getPaciente(DNI);
                     if (p == null) {
                    	 JOptionPane.showMessageDialog(null,
                                 "No se encontro un paciente con dicho DNI","Warning", 2);
                     }
                 } catch (Exception e) {
                     JOptionPane.showMessageDialog(null,
                             "No se ingreso un DNI valido","Warning", 2);
                 }
             }while (p == null);
        } else {
            p = system.crearPaciente();        
        }

        return p;
    }

    public void cancelarTurno() {
        int salir;
        Turno t;

        do {
            t = getTurno();
            if (t == null) {
                salir = JOptionPane.showConfirmDialog(null,
                    "No se encontro el turno, desea buscar uno nuevo?",
                    "Continuar", JOptionPane.YES_NO_OPTION);
            } else {
                salir = JOptionPane.NO_OPTION;
            }
        } while (salir == JOptionPane.YES_OPTION);

        if (!(t == null) && !t.estaDisponible()) {
            t.setPaciente(null);
            JOptionPane.showMessageDialog(null, "El turno se cancelo con exito");
        }
    }

    private Turno getTurno() {
        int matricula;
        Medico m = null;

        do{
            try {
                matricula = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Ingrese la matricula del medico", "Buscar Medico", 3));
                m = getMedico(matricula);
                if (m == null) {
               	 JOptionPane.showMessageDialog(null,
                            "No se encontro un medico con dicha Matricula","Warning", 2);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "No se ingreso una matricula valida","Warning", 2);
            }
        }while (m == null);

        FiltroAnd f = new FiltroAnd(new FiltroFecha(), new FiltroHora());
        ArrayList<Turno> aux;

        for (Medico med : medicos) {
            if (med.equals(m)) {
                aux = med.devolverTurnos(f);

                if (!aux.isEmpty()) {
                    return aux.get(0);
                }
            }
        }
        return null;
    }

    @Override
    public void ejecuto() {
        boolean salir = false;
        int i;

        do {
            i = interfazSecretaria.mostrarOpciones();
            switch(i) {
                case 0:
                    salir = true;
                    break;
                case 1:
                    Paciente paciente = getPaciente();
                    cargarTurno(paciente);
                    break;
                case 2:
                    cancelarTurno();
                    break;
            }
        } while (!salir);
    }
}
