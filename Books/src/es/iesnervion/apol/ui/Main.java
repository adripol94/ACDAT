package es.iesnervion.apol.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import es.iesnervion.apol.controllers.ManejadoraBook;
import es.iesnervion.apol.models.TipoBook;
import es.iesnervion.apol.models.TipoBookExt;
import es.iesnervion.apol.models.TipoTitle;

/**
 * Prueba de la clase manejadora, para probar un comportamiento perfecto de la manejadora, crearemos una aplicacion
 * de consola con la que gestionaremos todos los libros.
 * 
 * @author adripol94
 * @version 1.0
 */
public class Main {
	//Scanner
	private static final Scanner in = new Scanner(System.in);
	
	//Iniciaciond e la manejadora.
	private static final ManejadoraBook manejadora = new ManejadoraBook("data/books.xml");

	public static void main(String[] args) {
		manejadora.openFile();
		
		int opc;
		
		do {
			opc = menu();
			accionMenu(opc);
		} while (opc != 5);

	}
	
	/*
	 * Impprime el menu.
	 */
	private static int menu() {
		System.out.println("\n 1. Visualizar todos los datos");
		System.out.println("2. Introducir datos");
		System.out.println("3. Borrar un libro");
		System.out.println("4. Guardar");
		System.out.println("5. Salir");
		return pedirInt("Elija una opcion");
	}
	
	/**
	 * Maneja las acciones del menu
	 * @param opc Opcion seleccionada por el usuario.
	 */
	private static void accionMenu(int opc) {
		
		switch (opc) {
		case 1:
			listarLibros();
			break;
		case 2:
			añadirLibro();
			break;
		case 3:
			borrarUnLibro();
			break;
		case 4:
			guardarLibros();
			break;
		case 5:
			System.out.println("Saliendo... Hasta la vista");
			break;
		default:
			System.out.println("Opción desconocida");
			break;
		}
	}
	
	/*
	 * Pedira un titulo y lo borrara.
	 */
	private static void borrarUnLibro() {
		String str = pedirString("Introduzca el titulo del libro");
		boolean res = manejadora.borrarLibro(str);
		
		if (res)
			System.out.println(str + " se ha borrado con exito");
		else
			System.out.println(str + " no se ha podido borrar, puede que no se haya encontrado, verifique el nombre");
	}

	/*
	 * Guarda todos los libros introducidos
	 */
	private static void guardarLibros() {
		String res = manejadora.save();
		
		if (res != null)
			System.out.println("Se ha guardado los datos con exito");
		else
			System.out.println("Ha ocurrido un error!");
	}

	/*
	 * Añade un TipoLibro a la manejadora.
	 */
	private static void añadirLibro() {
		TipoBook tipoBook = pedirBook();
		
		try {
			manejadora.addTipoeBook(tipoBook);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Pide por consola y crea un TipoBook
	 */
	private static TipoBook pedirBook() {
		TipoBook tB = new TipoBook();
		TipoTitle tT = pedirTitle();
		
		tB.setCategory(pedirString("Indique la categoria"));
		tB.setPrice(pedirShort("Indique el precio del libro"));
		tB.setYear(pedirShort("Indique el año en el cual salio el libro"));
		tB.setTitle(tT);
		tB.getAuthor().addAll(pedirAutor());
		
		return tB;
	}
	
	/*
	 * Pide un autor un numero indeterminada de veces a un String referente a autores, 
	 * hasta que el usuario no introduzca (S).
	 */
	private static List<String> pedirAutor() {
		char c;
		int i = 0;
		boolean salir = false;
		List<String> autores = new ArrayList<>();
		
		do {
			autores.add(i,pedirString("Indique un autor del libro"));
			c = pedirChar("Se ha introducido el autor correctamente, ¿Desea salir? (S/N) [RECUERDE MAYUS]");
			
			if (c == 'S')
				salir = true;
			
		} while (!salir);
		
		return autores;
	}

	/*
	 * Pide al usuario un unico titulo
	 */
	private static TipoTitle pedirTitle() {
		TipoTitle tT = new TipoTitle();
		
		tT.setLang(pedirString("Indique el lenguaje del titulo del libro"));
		tT.setValue(pedirString("Indique el titulo"));
		
		return tT;
	}
	
	/*
	 * Permite listar todos los libros
	 */
	private static void listarLibros() {
		List<TipoBook> libros = manejadora.tipoBookResort();
		
		for (TipoBook b : libros) {
			System.out.println(new TipoBookExt(b).toString());
		}
		
	}

	//Utilidades de Escaners.
	
	private static String pedirString(String str) {
		System.out.println(str);
		return in.nextLine();
	}
	
	private static short pedirShort(String str) {
		System.out.println(str);
		return Short.parseShort(in.nextLine());
	}
		
	private static int pedirInt(String str) {
		System.out.println(str);
		return Integer.parseInt(in.nextLine());
	}
	
	private static char pedirChar(String str) {
		System.out.println(str);
		return in.nextLine().charAt(0);
	}

}
