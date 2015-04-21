/**
 * 
 */
package ec.com.gesso.criteria.entity.attribute.decorator;

import javax.persistence.criteria.Predicate;

import ec.com.gesso.criteria.entity.attribute.AbstractAttribute;
import ec.com.gesso.criteria.operador.condicion.enumeration.EnumCondicion;

/**
 * @author gortiz
 *
 */
public class AttributeOperadoLogico<T extends AbstractAttribute, E extends EnumCondicion> extends AbstractAttributeDecorator<T> {
	
	private final Predicate operadorLogico;
	private final E comparacionEnum;

	public AttributeOperadoLogico(T field, Predicate operadorLogico, E comparacionEnum) {
		super(field);
		this.operadorLogico = operadorLogico;
		this.comparacionEnum = comparacionEnum;
	}

	/**
	 * @return the operadorLogico
	 */
	public Predicate getOperadorLogico() {
		return operadorLogico;
	}

	/**
	 * @return the comparacionEnum
	 */
	public E getComparacionEnum() {
		return comparacionEnum;
	}

}
