/**
 * 
 */
package ec.com.gesso.criteria.operador.condicion.factory;

import ec.com.gesso.criteria.entity.attribute.AbstractAttribute;
import ec.com.gesso.criteria.operador.condicion.Condicionable;
import ec.com.gesso.criteria.operador.condicion.enumeration.EnumCondicion;

/**
 * @author gortiz
 *
 */
public interface FactoryFieldValue<F extends AbstractAttribute, E extends EnumCondicion> {
	
	Condicionable<F> newInstance(final E condicion);

}
