package exMarzo;

public enum Marca {
	SN("Sony"), SG("Seagate"), IN("Intel-Core"), SM ("Samsung");
	
	String marca;
	
	Marca (String marca){
		setMarca(marca);
	}
	
	private void setMarca(String marca){
		this.marca=marca;
	}
	
	String getMarca(){
		return marca;
	}
	
	String[] elegirMarca(){
		String[] marcaElegida = new String [marca.length()];
		for (Marca marca : values()) {
			marcaElegida = new String[]{marca.name()};
		}
		return marcaElegida;
	}
}
