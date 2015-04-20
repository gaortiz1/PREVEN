/**
 * 
 */
package ec.com.gesso.criteria.operador.condicion.proxy;

import ec.com.gesso.criteria.entity.attribute.AbstractAttribute;
import ec.com.gesso.criteria.operador.condicion.Condicionable;

/**
 * @author gortiz
 *
 */
public abstract class AbstractProxyField<T extends AbstractAttribute> implements Condicionable<T> {
	
	protected final Condicionable<T> condicion;

	protected AbstractProxyField(Condicionable<T> condicion) {
		this.condicion = condicion;
	}

}
