package ejercicio;

import java.util.Arrays;
/**
 * En esta clase trabajaremos con una lista de objetos tipo piso {@link Piso}
 * 
 * @author danim
 * @version 1.0
 */
public class Inmobiliaria {

	Piso[] lista;
	private int numVendedores;
	private int numPisos;

	public Inmobiliaria(Piso[] lista, int numVendedores) {
		this.lista = lista;
		this.numVendedores = numVendedores;
	}

	public Piso[] getLista() {
		return lista;
	}

	public void setLista(Piso[] lista) {
		this.lista = lista;
	}

	public int getNumVendedores() {
		return numVendedores;
	}

	public void setNumVendedores(int numVendedores) {
		this.numVendedores = numVendedores;
	}

	@Override
	public String toString() {
		return "Inmobiliaria [lista=" + Arrays.toString(lista) + ", numVendedores=" + numVendedores + "]";
	}

	public void add(Piso p) {
		lista[numPisos] = p;
		numPisos++;
	}

	
	/**
	 * Este método calcula el precio final de venta de un piso
	 * 
	 * @param porcen Aquí pasamos el porcentaje de ganancia 
	 * @param id Lo usamos para seleccionar el piso de la lista 
	 * @return El precio final del piso
	 */
	public double calcularPrecioFinalVenta(double porcen, int id) {
		double total = 0, totPorcen = 0, cien = 100;
		int index = findByIdV2(id);
		if(index >=0) {
		totPorcen = (lista[index].getPrecioVenta() * porcen) / cien;
		total = lista[index].getPrecioVenta() + totPorcen;
		lista[index].setPvp(total);
		}
		return total;
			
		}
	
		/**
		 * Este método sirve para buscar un objeto dentro de la lista utilizando su id
		 * @param codigo El id del objeto a buscar
		 * @return El id del objeto encontrado
		 */
		public int findByIdV2(int codigo) {
			int i = 0;
			boolean encontrado = false;
			
			while (i < lista.length && !encontrado) {
				Piso deLista = lista[i];
				
				if(deLista.getId() == codigo) {
					encontrado = true;
				}else {
					i++;
				}
			}
			if (encontrado) {
				return i;
			}else {
				return -1;
			}
	}
	
	
	/**
	 * Como el método anterior pero buscamos usando el estado en lugar del id
	 * 
	 * @param estado El número del estado
	 * @return Los pisos de ese estado
	 */
	public int findByEstadov2(int estado) {
		int i = 0;
		boolean encontrado = false;
		
		while (i < lista.length && !encontrado) {
			Piso deLista = lista[i];
			
			if(deLista.getEstado() == estado) {
				encontrado = true;
			}else {
				i++;
			}
		}
		if (encontrado) {
			return i;
		}else {
			return -1;
		}
	}
	
	/**
	 * Este método sirve para editar el precio base de un piso
	 * 
	 * @param id El id usado para buscar el piso
	 * @param nuevoPrecio El nuevo precio asignado
	 */
	public void editPrecio(int id, double nuevoPrecio){
		int index = findByIdV2(id);
		if (index >= 0) {
			lista[index].setPrecioVenta(nuevoPrecio);
		}
	}
	
	/**
	 * Este método se usa para calcular el precio del metro cuadrado de un piso
	 * 
	 * @param id El id para buscar el piso
	 * @return El precio por metro cuadrado del piso seleccionado
	 */
	public double calcularPrecioM2(int id) {
		double precioM2=0;
		int index = findByIdV2(id);
		if (index >= 0) {
			precioM2 = lista[index].getPvp() / lista[index].getMetros2();
		}
		
		return precioM2;
	}
	
	/**
	 * Este método sirve para calcular el precio de todos los pisos de un tipo de estado
	 * 
	 * @param estado El estado a buscar
	 * @return La suma de los precios
	 */
	public double totInmoSeminuevos(int estado) {
		double totInmoSeminuevos = 0;
		
		int index = findByEstadov2(estado);
		if (index >= 0) {
			while(index < lista.length) {
				totInmoSeminuevos+=lista[index].getPvp();
			}
		}
		
		return totInmoSeminuevos;
	}
	
	/**
	 * En este método calculamos la ganancia total de los vendedores
	 * 
	 * @return gananciaVendedores La suma total de la ganancia de los vendedores
	 */
	public double calcularGananciaVendedores() {
		double gananciaVendedores = 0;
		for (int i = 0; i < lista.length; i++) {
			gananciaVendedores+=lista[i].getPvp();
		}
		
		return gananciaVendedores;
	}
	

}
