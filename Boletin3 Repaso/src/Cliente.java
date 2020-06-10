import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Cliente implements Comparable<Cliente>{

	public static Cliente guardaCliente() {
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        Cliente miCliente = new Cliente("", "");
        String dni, nombre, fechaNaci;
        
        do{
            System.out.print("Insterta fecha nacimiento (con formato dd-MM-yyy): ");
            fechaNaci = sc.next();
        } while(!miCliente.setFechaNacimiento(fechaNaci));
        
        if (!Discoteca.comprobarEdad(miCliente.getFechaNaci())) {
            System.out.println("Error, edad incorrecta :(");
            return null;
        }
        
        System.out.print("Insterta dni: ");
        dni = sc.next();
        miCliente.setDni(dni);
        
        System.out.print("Insterta nombre: ");
        nombre = sc.next();
        miCliente.setNombre(nombre);
        
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
