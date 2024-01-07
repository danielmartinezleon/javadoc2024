package ejercicio;

import java.util.Scanner;

public class Ppal {

	public static void main(String[] args) {
		
		String aux;
		Scanner sc = new Scanner(System.in);
		Piso p;
		String direccion="";
		int metros2 = 0;
		int estado = 0;
		double precioVenta = 0;
		int id = 0;
		double pvp = 0;
		int opcion = 0;
		int tam = 10;
		int numVendedores = 0;
		double np=0;
		
		System.out.println("Diga cuantos vendedores son:");
		aux=sc.nextLine();
		numVendedores=Integer.parseInt(aux);
		
		Piso[] lista = new Piso[tam];
		Inmobiliaria inmo = new Inmobiliaria(lista, numVendedores);
		
		do {
			imprimirMenu();
			aux=sc.nextLine();
			switch (opcion) {
			
			case 1:
				System.out.println("Diga dirección:");
				direccion= sc.nextLine();
				System.out.println("Diga metros^2:");
				aux=sc.nextLine();
				metros2=Integer.parseInt(aux);
				System.out.println("Diga estado(1-nuevo, 2-Seminuevo, 3-Reformar):");
				aux=sc.nextLine();
				estado=Integer.parseInt(aux);
				System.out.println("Diga precio venta:");
				aux=sc.nextLine();
				precioVenta=Double.parseDouble(aux);
				
				System.out.println("Diga id:");
				aux=sc.nextLine();
				id=Integer.parseInt(aux);
				
				p= new Piso(direccion, metros2, estado, precioVenta, id, pvp);
				inmo.add(p);
				break;
				
			case 2:
				inmo.calcularPrecioFinalVenta(numVendedores, id);
				break;
			case 3:
				inmo.findByEstadov2(estado);
				break;
			case 4:
				inmo.editPrecio(id, np);

			default:
				break;
			}
			
		} while (opcion != 0);

	}
	
	public static void imprimirMenu() {
		System.out.println("""
			1) Agregar un nuevo piso a la lista leyendo los datos por teclado.
			2) Calcular Precio Final Venta
			3) Buscar y devolver todos los pisos cuyo estado es nuevo.
			4) Modificar el precio de un piso de venta que quiere el dueño por uno nuevo leído por teclado, por si el dueño quiere rebajar el precio.
			5) Calcular el precio del metro cuadro de un piso, dividiendo el precio final de venta al público por el número de metros que tiene el
			piso.
			6) Calcular cuánto ganaría la inmobiliaria si vendiera todos los pisos cuyo estado es seminuevo.
			7) Calcular cuánto ganaría cada vendedor, si se vendieran todos los pisos y se repartieran las ganancias a partes iguales.
				""");
	}

}
