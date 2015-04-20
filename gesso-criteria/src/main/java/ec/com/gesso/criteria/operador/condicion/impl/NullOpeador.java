/**
 * 
 */
package ec.com.gesso.criteria.operador.condicion.impl;

import javax.persistence.criteria.Predicate;

import ec.com.gesso.criteria.entity.attribute.AbstractAttribute;
import ec.com.gesso.criteria.operador.condicion.Condicionable;

/**
 * @author gortiz
 *
 */
public final class NullOpeador<T extends AbstractAttribute> implements Condicionable<T> {
	
	private NullOpeador() {};
	
	public static <T extends AbstractAttribute> Condicionable<T> noExistOperador() {
        return new NullOpeador<T>();
    }

	@Override
	public Predicate getPredicate(T row) {
		return null;
	}
}
