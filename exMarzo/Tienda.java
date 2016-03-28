package exMarzo;

import java.util.ArrayList;

import utiles.Menu;
import utiles.Teclado;

public class Tienda {

	private ArrayList<Producto> productos = new ArrayList<Producto>();

	
	void annadirProducto(Marca marca, Componentes componente, double precio, String descriptor)
		throws ComponenteInvalidoException, MarcaInvalidaException, PrecioInvalidoException, DescripcionInvalidaException, IdNoValidoException, ProductoYaExisteException{
		
		Producto producto = new Producto(marca, componente, precio, descriptor);
		if(!productos.contains(producto))
		productos.add(producto);
		else
			throw new ProductoYaExisteException("Ya existe");
	}
	
	void borrarProducto(int identificador) throws IdNoValidoException{
		productos.remove(productos.get(productos.indexOf(identificador)));
	}
	
	Producto buscarId(int identificador) throws IdNoValidoException{
		if(!productos.contains(identificador)) 
			throw new IdNoValidoException("No existe este identificador");
		return productos.get(productos.indexOf(identificador));}

	
	Producto buscarMarca(Marca marca) throws MarcaInvalidaException{
		if(!productos.contains(marca)) 
			throw new MarcaInvalidaException("Marca invalida");
		return productos.get(productos.indexOf(marca));
		}
	
	Producto incrementarPrecio(double precio) throws PrecioInvalidoException{
		Producto producto = productos.get(productos.indexOf(precio));
			if(producto.getPrecio()<100)
				producto.setPrecio(precio*1.1);
			return producto;
			
	}
	
	public void incrementar() throws PrecioInvalidoException{
		for (int i = 0; i < productos.size(); i++) {
			if (productos.get(i).getPrecio()<100){
				productos.get(i).setPrecio(productos.get(i).getPrecio() * 1.1);
			}
		}
	}
	
	public String mostrarTienda(){
			String mensaje = "";
		if (productos.isEmpty()){
			
			mensaje = "La lista está vacia";
			return mensaje;
		}else{
			for(int i = 0; i < productos.size(); i++){
				mensaje = "\n" + productos.get(i);
			}
			return mensaje;
				
		}
	}
	
	@Override
	public String toString() {
		return "Tienda [productos=" + productos + "]";
	}
}

	


