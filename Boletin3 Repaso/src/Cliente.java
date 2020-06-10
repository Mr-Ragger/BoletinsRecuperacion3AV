import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Cliente implements Comparable<Cliente>{

	public static Cliente guardarCliente() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String dni, nombre, fecha;
		
		System.out.print("Introduce el Nombre: ");
		nombre = sc.next();
		
		System.out.print("Introduce el DNI: ");
		dni = sc.next();
		
		Cliente miCliente = new Cliente(dni, nombre);
		do {
			System.out.print("Intoduce la fecha de nacimiento(dd-mm-yyyy): ");
			fecha = sc.next();
					
		} while(!miCliente.setFechaNacimiento(fecha));
				
		return miCliente;
	}
	
	private String dni;
	private String nombre;
	private LocalDate fechaNaci;
	
	public Cliente(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}
	
	public Cliente(String dni, String nombre, LocalDate fechaNaci) {
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNaci = fechaNaci;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNaci() {
		return fechaNaci;
	}

	public void setFechaNaci(LocalDate fechaNaci) {
		this.fechaNaci = fechaNaci;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return Period.between(fechaNaci, LocalDate.now()).getYears();	
	}
	
	public boolean setFechaNacimiento(String fechaNacimiento) {
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		try {
		    this.setFechaNaci(LocalDate.parse(fechaNacimiento, pattern));
		} catch (DateTimeParseException e) {
			//System.out.println(e.getMessage());
			System.out.println("La fecha esta en un formato incorrecto(dd-mm-yyyy)");
			return false;
		}
		
		return true;
	}

	public String toString() {
		return "DNI: " + dni + " Nombre: " + nombre + " Fecha de nacimiento: " + fechaNaci;
	}

	@Override
	public int compareTo(Cliente c) {
		
		int cmp = (this.fechaNaci.getYear() - c.getFechaNaci().getYear());
	    if (cmp == 0) {
	        cmp = (this.fechaNaci.getMonthValue() - c.getFechaNaci().getMonthValue());
	        if (cmp == 0) {
	            cmp = (this.fechaNaci.getDayOfMonth() - c.getFechaNaci().getDayOfMonth());
	        }
	    }
	    return cmp;
	}
	

}
