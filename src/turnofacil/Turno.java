package turnofacil;

import java.time.LocalDateTime;

public class Turno {
    private LocalDateTime fecha;
    private final int id;
    private Medico medico;
    private Paciente paciente;
    static int contador = 0;

    public Turno(Medico medico, LocalDateTime fecha) {
        this.id = contador;
        contador++;
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
        return "Turno{" + "fecha=" + fecha.toLocalDate() + ", hora =" +
            fecha.toLocalTime() + ", id=" + id + ", medico=" + medico.getNombre()
            + " " + medico.getApellido() + ", paciente=" + paciente + "}";
    }
}
