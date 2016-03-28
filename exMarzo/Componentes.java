package exMarzo;

public enum Componentes {
	DD("Disco Duro"), PR("Procesadores"), MR("Memoria RAM"), FA("Fuente de Alimentacion");
	
	String componente;
	
	Componentes(String componente){
		setComponente(componente);
	}
	
	private void setComponente(String marca){
		this.componente=marca;
	}
	
	String getComponente(){
		return componente;
	}
	
	String[] elegirMarca(){
		String[] componenteElegido = new String [componente.length()];
		for (Componentes componente : values()) {
			componenteElegido = new String[]{componente.name()};
		}
		return componenteElegido;
	}
}
