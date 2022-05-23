package turnofacil;

import java.time.LocalDate;

public class Turno {
    private LocalDate fecha;
    private int id;
    private Medico medico;
    private Paciente paciente;

    public Turno(int id, Medico medico, LocalDate fecha) {
        this.id = id;
        this.medico = medico;
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
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