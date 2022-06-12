package turnofacil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		int i = 0;
		LocalDateTime fecha = LocalDateTime.now();
		LocalDateTime fecha2 = LocalDateTime.of(2022, 12, 5, 8, 30);
		Medico Roberto = new Medico("Rober", "Roberto", "Luis", 10023, 43097212, "1234");
		Turno nuevo = new Turno(Roberto, fecha);
		Turno nuevo2 = new Turno(Roberto, fecha2);
		Roberto.addTurno(nuevo);
		Roberto.addTurno(nuevo2);
		Roberto.Ejecuto();
	}
}