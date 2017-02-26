package es.iesnervion.apol.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import es.iesnervion.apol.controllers.ManejadoraBook;
import es.iesnervion.apol.models.TipoBook;
import es.iesnervion.apol.models.TipoTitle;

/**
 * Testea solo el primer objeto, entenderemos que si entra bien el primero el segundo puede entrar. <br>
 * <b>Si es cierta para k es cierta para k+ (Principio de induccion).</b>
 * @author adripol94
 *
 */
public class ManejadoraBookTest {
	private ManejadoraBook manejator;
	
	public ManejadoraBookTest() {
		manejator = new ManejadoraBook("data//books.xml");
		manejator.openFile();
	}
	
	@Test
	public void testTipoBookResortFirst() {
		List<TipoBook> result = manejator.tipoBookResort();
		TipoBook t = result.get(0);
		
		assertEquals("en", t.getTitle().getLang());
		assertEquals("Everyday Italian", t.getTitle().getValue());
		assertEquals("COOKING", t.getCategory());
		assertEquals((float)30.0, t.getPrice(), 0);
		assertEquals((short)2005, t.getYear());
		assertArrayEquals(new String[]{"Giada De Laurentiis"}, t.getAuthor().toArray());
	}
	
	@Test
	public void testSave() {
		
		TipoTitle tipoTitle = new TipoTitle();
		tipoTitle.setLang("es");
		tipoTitle.setValue("Ejemplo de prueba");
		
		TipoBook nuevoTipoBook = new TipoBook();
		nuevoTipoBook.setCategory("WEB");
		nuevoTipoBook.setPrice(50);
		nuevoTipoBook.setTitle(tipoTitle);
		nuevoTipoBook.setYear((short)1994);
		nuevoTipoBook.getAuthor().add("Adrian Pol Alcala");
		 
		try {
			manejator.addTipoeBook(nuevoTipoBook);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertNotEquals(null, manejator.save());
	}
	
	@Test
	public void testTipoBookResortEnd() {
		List<TipoBook> result = manejator.tipoBookResort();
		TipoBook t = result.get(result.size() - 1);
		
		assertEquals("es", t.getTitle().getLang());
		assertEquals("Ejemplo de prueba", t.getTitle().getValue());
		assertEquals("WEB", t.getCategory());
		assertEquals((float)50, t.getPrice(), 0);
		assertEquals((short)1994, t.getYear());
		assertArrayEquals(new String[]{"Adrian Pol Alcala"}, t.getAuthor().toArray());
	}
}
