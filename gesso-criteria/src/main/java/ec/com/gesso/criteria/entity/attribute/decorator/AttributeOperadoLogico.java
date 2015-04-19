/**
 * 
 */
package ec.com.gesso.criteria.entity.attribute.decorator;

import ec.com.gesso.criteria.WrapperPredicable;
import ec.com.gesso.criteria.entity.attribute.AbstractAttribute;
import ec.com.gesso.criteria.operador.condicion.enumeration.EnumCondicion;

/**
 * @author gortiz
 *
 */
public class AttributeOperadoLogico<T extends AbstractAttribute, E extends EnumCondicion> extends AbstractAttributeDecorator<T> {
	
	private final WrapperPredicable operadorLogico;
	private final E comparacionEnum;

	public AttributeOperadoLogico(T field, WrapperPredicable operadorLogico, E comparacionEnum) {
		super(field);
		this.operadorLogico = operadorLogico;
		this.comparacionEnum = comparacionEnum;
	}

	/**
	 * @return the operadorLogico
	 */
	public WrapperPredicable getOperadorLogico() {
		return operadorLogico;
	}

	/**
	 * @return the comparacionEnum
	 */
	public E getComparacionEnum() {
		return comparacionEnum;
	}

}
