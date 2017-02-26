package es.iesnervion.apol.controllers;

import java.io.File;
import java.io.StringWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import es.iesnervion.apol.models.TipoBook;
import es.iesnervion.apol.models.TipoBookStore;

/**
 * Clase manejadora de {@link TipoBook}.
 * @see TipoBookStore
 * @see List
 * @author adripol94
 * @version 1.0
 */
public class ManejadoraBook {
	//Atributos
	
	/**
	 * Aquí se van a cargar los datos del xml en memoria
	 * @see TipoBookStore
	 */
	private TipoBookStore tipoBookStore;
	
	/**
	 * File del archivo xml pricipal, este archivo se va a usar para leer principalmente
	 * pero tambien se usará para escribir si deseamos sobreescribir el archivo.
	 */
	private File archivoXML;
	
	
	//Constructor
	
	/**
	 * Constructor que inicializa a {@link #archivoXML}.
	 * @param urlFile String del archivo a manejar.
	 */
	public ManejadoraBook(String urlFile) {
		archivoXML = new File(urlFile);
	}
	
	//Metodos
	
	/**
	 * Permite abrir el archivo {@link #archivoXML} , recorrerlo entero y guarda lso datos en {@link #tipoBookStore}.
	 */
	public void openFile() {
		JAXBContext context;
		
		try {
			context = JAXBContext.newInstance(TipoBookStore.class);
			Unmarshaller u = context.createUnmarshaller();
			tipoBookStore = (TipoBookStore)u.unmarshal(archivoXML);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Borra un libro por el titulo exacto del libro, devuelve <code>true</code> o <code>false</code>
	 * en caso de borrarlo o no.
	 * @param titutlo String exacto del libro
	 * @return <code>true</code> de ser borrado, <code>false</code> en caso de no borrar nada
	 */
	public boolean borrarLibro(String titutlo) {
		boolean salir = false;
		TipoBook tB;
		
		for (int i=0; i < tipoBookStore.getBook().size() && !salir; i++) {
			tB = tipoBookStore.getBook().get(i);
			
			if (tB.getTitle().getValue().equals(titutlo)) {
				salir = true;
				tipoBookStore.getBook().remove(i);
			}
		}
		
		//El unico objeto que cambia si se encuentra es salir, asi que lo usaremos para referencia.
		return salir;
	}
	
	/**
	 * Busca un libro por el titulo, devuelve nulo si no lo encuntra o {@link TipoBook} si lo encuentra
	 * @param titulo Titulo del libro exacto.
	 * @return <code>null</code> o {@link TipoBook}
	 */
	public TipoBook buscarPorTitutlo(String titulo) {
		boolean salir = false;
		TipoBook tB = null;
		
		for (int i=0; i < tipoBookStore.getBook().size() && !salir; i++) {
			tB = tipoBookStore.getBook().get(i);
			
			if (tB.getTitle().getValue().equals(titulo))
				salir = true;
		}
		
		return tB;
	}
	
	/**
	 * Añade un {@link TipoBook} a {@link #tipoBookStore}. <br>
	 * <b>No se guardará el archivo, este se quedará en memoria, hasta que no usemos 
	 * {@link #save()} no se guardara en el archivo.</b>
	 * @param tipoBook Objeto del libro a guardar
	 * @throws Exception En caso de que no se haya abierto el archivo ({@link #openFile()}).
	 */
	public void addTipoeBook(TipoBook tipoBook) throws Exception {
		if (tipoBookStore == null)
			throw new Exception("tipoBookStore is null, please openFile first.");
		
		tipoBookStore.getBook().add(tipoBook);
	}
	
	/**
	 * Devuelve en formato {@link List} todos los {@link TipoBook}.
	 * @return {@link List} de {@link TipoBook}
	 */
	public List<TipoBook> tipoBookResort() {
	 	return tipoBookStore.getBook();
	}
	
	/**
	 * Guadara {@link #tipoBookStore} parseandolo en un archivo xml, el destino se especificara en el parametro.
	 * @param urlDestino Path de destino en el que se guardara los datos.
	 * @return Devuelve todo el {@link #tipoBookStore} en formato {@link String}, en el caso que no se haya podido
	 * guardar bien devolvera <code>null</code>.
	 */
	public String save(String urlDestino) {
		JAXBContext contexto;
		Marshaller marshalero;
		StringWriter writer = null;
		
        try {
        	//Configuration
            contexto = JAXBContext.newInstance(TipoBookStore.class);
            marshalero = contexto.createMarshaller();
            marshalero.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            writer = new StringWriter();
            //saving changes to new file xml
            marshalero.marshal(tipoBookStore, new File(urlDestino));
            //putting all file to writer
            marshalero.marshal(tipoBookStore, writer);
            
        } catch (JAXBException ex) {
        	ex.printStackTrace();
            Logger.getLogger(ManejadoraBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return writer.toString();
	}
	
	/**
	 * Guadara {@link #tipoBookStore} parseandolo en un archivo xml, el destino sera el mismo que se introdujo en
	 * {@link #ManejadoraBook(String)}. <b>Se sobreescribira el archivo.</b>
	 * @return Devuelve todo el {@link #tipoBookStore} en formato {@link String}, en el caso que no se haya podido
	 * guardar bien devolvera <code>null</code>.
	 */
	public String save() {
		JAXBContext contexto;
		Marshaller marshalero;
		StringWriter writer = null;
		
        try {
        	//Configuration
            contexto = JAXBContext.newInstance(TipoBookStore.class);
            marshalero = contexto.createMarshaller();
            marshalero.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            writer = new StringWriter();
            //saving changes to same file xml
            marshalero.marshal(tipoBookStore, archivoXML);
            //putting all file to writer
            marshalero.marshal(tipoBookStore, writer);
            
        } catch (JAXBException ex) {
        	ex.printStackTrace();
            Logger.getLogger(ManejadoraBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return writer.toString();
	}
}
