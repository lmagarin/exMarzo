package exMarzo;

import utiles.Menu;
import utiles.Teclado;

public class testProducto {
		
		static Menu menu = new Menu ("Productos", new String[]{"Anadir producto","Borrar producto","Buscar por id", "Buscar por Marca","Mostrar tienda", "Aumentar precio"});
		static Menu menuMarcas = new Menu ("Marcas", new String[]{ " Sony ", " Seagate ", " Intel-Core ", " Samsung "});
		static Menu menuComponentes = new Menu("Componentes", new String[]{"Discos Duros","Procesadores","Memoria Ram","Fuente de Alimentacion"});
		
		static Producto productos;
		static Tienda tienda;
	
	private static void annadir() throws ComponenteInvalidoException, MarcaInvalidaException, PrecioInvalidoException, DescripcionInvalidaException, IdNoValidoException, ProductoYaExisteException {
		int id = 1;
		String descriptor;
		double precio;
		tienda.annadirProducto(menuM(), menuC(), precio = Teclado.leerDecimal("Introduce el precio"), descriptor = Teclado.leerCadena("Introduce la descripcion"));
		
	}
	
	private static void borrar() throws IdNoValidoException{
		
		tienda.borrarProducto(Teclado.leerEntero("Introduce un identificador"));
		
	}
	
	private static void buscarId() throws IdNoValidoException{
		
		tienda.buscarId(Teclado.leerEntero("Introduce mael id a buscar"));
	}
	
	private static void buscarMarca() throws MarcaInvalidaException{
		
		tienda.buscarMarca(menuM());
	}
	
	
	
	private static Componentes menuC() {
		int opcion = menuComponentes.gestionar();
		do {
			switch (opcion) {
			case 1: 
				System.out.println("Has seleccionado Discos Duros");
				return Componentes.DD;

			case 2: 
				System.out.println("Has seleccionado Procesadores");
				return Componentes.PR;

			case 3: 
				System.out.println("Has seleccionado Memoria Ram");
				return Componentes.MR;
			case 4: 
				System.out.println("Has seleccionado Fuentes de Alimentacion");
				return Componentes.FA;

			default:
				System.out.println("Bye");
				return null;
			}
		} while (opcion != menuComponentes.numOpciones);
	}

	private static Marca menuM() {
		int opcion = menuMarcas.gestionar();
		do {
			switch (opcion) {
			case 1: 
				System.out.println("Has seleccionado Sony");
				return Marca.SN;

			case 2: 
				System.out.println("Has seleccionado Seagate");
				return Marca.SG;

			case 3:
				System.out.println("Has seleccionado Intel Core");
				return Marca.IN;
			case 4: 
				System.out.println("Has seleccionado Samsung");
				return Marca.SM;

			default: 
				System.out.println("Bye");
				return null;
			}
		} while (opcion != menuMarcas.numOpciones);
	}


public static void main (String[] args) throws ComponenteInvalidoException, MarcaInvalidaException, PrecioInvalidoException, DescripcionInvalidaException, IdNoValidoException, ProductoYaExisteException{
	int opcion;
	tienda = new Tienda();
	do{ 
		opcion = menu.gestionar();
		
		switch(opcion){
		case 1:
			annadir();
		case 2:
			borrar();
		case 3:
			buscarId();
		case 4:
			buscarMarca();
		case 5:
			tienda.mostrarTienda();
		case 6:
			tienda.incrementar();
		default:
			return;
		}
	}while(opcion != menu.numOpciones);

}

}

