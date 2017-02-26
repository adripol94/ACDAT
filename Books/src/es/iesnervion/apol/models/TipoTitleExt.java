package es.iesnervion.apol.models;

/**
 * Clase extendida de {@link TipoBook}. <br>
 * Implementa un {@link Object#toString()} Override.
 * @see TipoTitle
 * @author adripol94
 */
public class TipoTitleExt extends TipoTitle {
	public TipoTitleExt() {super();}
	
	public TipoTitleExt(TipoTitle tipoTitle) {
		super();
		super.lang = tipoTitle.lang;
		super.value = tipoTitle.value;
	}
	
	/**
	 * To string sobreescrito.
	 */
	@Override
	public String toString() {
		return "Value: " + super.value + ", Lang: " + super.lang;
 	}
}
