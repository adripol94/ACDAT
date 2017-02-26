package es.iesnervion.apol.models;

import java.util.Arrays;

/**
 * Clase extendida de {@link TipoBook}. <br>
 * Implementa un {@link Object#toString()} Override.
 * @see TipoBook
 * @author adripol94
 */
public class TipoBookExt extends TipoBook {
	
	public TipoBookExt() {}
	
	public TipoBookExt(TipoBook tipoBook) {
		super();
		this.author = tipoBook.getAuthor();
		this.category = tipoBook.getCategory();
		this.price = tipoBook.getPrice();
		this.title = tipoBook.getTitle();
		this.year = tipoBook.getYear();
	}
	
	/**
	 * To string sobreescrito.
	 */
	@Override
	public String toString() {
		return "Title: \n " + new TipoTitleExt(super.title).toString() + "\n Category: " + this.category + "\n Price: " + this.price
				+ "\n Year: " + this.year + "\n Autor: \n" + Arrays.toString(this.author.toArray()) + "\n";
	}
}
