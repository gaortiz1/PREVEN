/**
 * 
 */
package ec.com.gesso.criteria.operador.condicion.enumeration;

/**
 * @author gortiz
 *
 */
public enum InterseccionEnum implements EnumCondicion {
	
	IS_NULL,
	IS_NOT_NULL,
	IN,
	NOT_IN;

	@Override
	public EnumCondicion getEnumCondicion() {
		return this;
	}

}
