package exMarzo;

import java.util.regex.Pattern;

import utiles.Menu;
import utiles.Teclado;

public class Producto {

	Pattern patron = Pattern.compile("^([a-zA-ZÒ—\\d\\,\\.\\-]+\\s){2,}[a-zA-ZÒ—\\d\\.]+$");
	
	private Marca marca;
	private Componentes componente;
	private String descriptor;
	private double precio;
	private String identificador;
	private int contador = 1;

	
	 Producto(String identificador) throws IdNoValidoException {
		this.identificador=identificador;
	}

	public Producto(Marca marca, Componentes componente, double precio, String descriptor) throws DescripcionInvalidaException, PrecioInvalidoException, ComponenteInvalidoException, PrecioInvalidoException, MarcaInvalidaException, IdNoValidoException {
		setMarca(marca);
		setComponente(componente);
		setDescriptor(descriptor);
		setIdentificador();
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) throws MarcaInvalidaException {
		if(marca == null)
			throw new MarcaInvalidaException("Marca no valida");
		this.marca=marca;
	}

	public Componentes getComponente() {
		return componente;
	}

	public void setComponente(Componentes componente) throws ComponenteInvalidoException {
		if(componente == null)
			throw new ComponenteInvalidoException("Fallo en el componente");
		this.componente=componente;
	}

	public String getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(String descriptor) throws DescripcionInvalidaException {
		if(!patron.matcher(descriptor).matches())
			throw new DescripcionInvalidaException("Minimo tres palabras");
		this.descriptor = descriptor;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) throws PrecioInvalidoException {
		if (precio <= 0)
			throw new PrecioInvalidoException("Precio incorrecto");
		this.precio = precio;
	}

	

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador() throws IdNoValidoException {
		this.identificador = String.valueOf(getMarca()) + "-" + getComponente() + "-" + getContador();
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}
	@Override
	public String toString() {
		return "Producto [patron=" + patron + ", marca=" + marca + ", componente=" + componente + ", descriptor="
				+ descriptor + ", precio=" + precio + ", identificador=" + identificador + ", contador=" + contador
				+ "]";
	}
}
	