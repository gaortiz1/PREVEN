package ec.com.gesso.criteria.operador.condicion;

import javax.persistence.criteria.Predicate;

import ec.com.gesso.criteria.entity.attribute.AbstractAttribute;

/**
 * 
 * @author gortiz
 *
 */
public interface Condicionable<T extends AbstractAttribute> {
	
	Predicate getPredicate(T row);

}
