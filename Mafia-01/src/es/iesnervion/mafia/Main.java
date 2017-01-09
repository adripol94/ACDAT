package es.iesnervion.mafia;

import es.iesnervion.mafia.model.Don;
import es.iesnervion.mafia.model.Famiglias;

public class Main {

	public static void main(String[] args) {
		
		Famiglias familia = new Famiglias("Fernandos", "Sevilla", (short) 187, 
				new Don("Palotes", "Fernando", "Padrino", "Sevilla"));
		
		Insertar.insertFamiglia(familia);
		
		
	}

}
