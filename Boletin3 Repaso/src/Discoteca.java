import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Discoteca {

	public static final int EDAD_MINIMA = 16;
	public static final int EDAD_JOVEN = 18;
	public static final int EDAD_ADULTO= 30;
	
	public static boolean comprobarEdad(LocalDate fechaNaci) {
		int edad;
		edad = Period.between(fechaNaci, LocalDate.now()).getYears();
		
		if(edad >= EDAD_MINIMA) {
			return true;
		}
				
		return false;
	}
	
	
	private ArrayList <Cliente> adolescentes;
	private ArrayList <Cliente> jovenes;
	private ArrayList <Cliente> adultos;
	private HashMap <String, Cliente> clientes;
	
	public Discoteca() {
		adolescentes = new ArrayList<Cliente>();
		jovenes = new ArrayList<Cliente>();
		adultos = new ArrayList<Cliente>();
		clientes = new HashMap<String, Cliente>();
	}

	public void anhadirCliente(Cliente c) {
		
		if(c.getEdad() > EDAD_ADULTO) {
			adultos.add(c);
		}else if(c.getEdad() > EDAD_JOVEN) {
			jovenes.add(c);
		}else {
			adolescentes.add(c);
		}
		
		clientes.put(c.getDni(), c);
	}
	
	public Cliente encontrarDni(String dni) {
		return clientes.get(dni);
	}
	
	public String toString() {
		String resultado = "";
		
		resultado += "Adolescentes: \n";
		Collections.sort(adolescentes);
		for (Cliente c:adolescentes) {
			resultado += c + "\n";
		}
		Collections.sort(jovenes);
		resultado += "Jovenes: \n";
		for (Cliente c:jovenes) {
			resultado += c + "\n";
		}
		Collections.sort(adultos);
		resultado += "Adultos: \n";
		for (Cliente c:adultos) {
			resultado += c + "\n";
		}
		
		return resultado;
	}
}
