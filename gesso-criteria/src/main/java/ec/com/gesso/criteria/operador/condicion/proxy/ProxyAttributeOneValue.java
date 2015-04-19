/**
 * 
 */
package ec.com.gesso.criteria.operador.condicion.proxy;

import javax.persistence.criteria.Predicate;

import ec.com.gesso.criteria.entity.attribute.basic.AttributeOneValue;
import ec.com.gesso.criteria.operador.condicion.Condicionable;

/**
 * @author gortiz
 *
 */
public class ProxyAttributeOneValue extends AbstractProxyField<AttributeOneValue> {

	public ProxyAttributeOneValue(Condicionable<AttributeOneValue> condicion) {
		super(condicion);
	}

	@Override
	public Predicate getPredicate(AttributeOneValue row) {
		if ( row != null && row.getNombreCampo() != null && row.getValue() != null){
			return this.condicion.getPredicate(row);
		}
		return null;
	}

}
