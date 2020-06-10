import java.util.Scanner;

public class Principal {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cliente prueba;
		
		prueba = Cliente.guardarCliente();
//		Cliente miCliente = new Cliente();
		System.out.println( prueba );
		
		mostrarMenu();
		
	}
	
	public static void mostrarMenu() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int opcionMenu;
		
		String menu = "----------MENU DE OPCIONES---------- \n"
				+ "- 1.. \n"
				+ "- 2.. \n"
				+ "- 3.. \n"
				+ "- 4.. \n"
				+ "- 0.Salir. \n";
		
		System.out.println(menu);
		
		System.out.print("Selecciona una opcion: ");
		opcionMenu = sc.nextInt();
	
		Principal.opcionMenu(opcionMenu);
		
		if(opcionMenu != 0) {
			mostrarMenu();
		}
	}	
	
	public static void opcionMenu(int opcion) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		switch(opcion) {
		
			case 1:
				Cliente c1 = Cliente.guardarCliente();
				System.out.println("Cliente guardado correctamente.");
				break;
			case 2:
				System.out.println("Mostrando libros");
				break;
			case 3:

				break;
			case 0:
				System.out.println("Saliendo del menu.");
				break;
				
			default:
				System.out.println("Opcion Invalida.");
				break;
			
		
		}
	
	}

}
