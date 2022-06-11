package turnofacil;

import java.time.LocalDateTime;

public class Turno {
    private LocalDateTime fecha;
    private int id; //no deberia ser final?
    private Medico medico;
    private Paciente paciente;

    public Turno(int id, Medico medico, LocalDateTime fecha) {
        this.id = id; //duda
        this.medico = medico;
        this.fecha = fecha;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public int getId() {
        return id;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public boolean estaDisponible() {
        return paciente == null;
    }

    @Override
    public String toString() {
        return "Turno{" + "fecha=" + fecha + ", id=" + id + ", medico=" + medico + ", paciente=" + paciente + '}';
    }
}