/**
 * 
 */
package ec.com.gesso.criteria.operador.condicion.enumeration;

/**
 * @author gortiz
 *
 */
public enum ComparacionEnum implements EnumCondicion{
	
	EQUAL,
	LIKE;

	@Override
	public EnumCondicion getEnumCondicion() {
		return this;
	}

}
