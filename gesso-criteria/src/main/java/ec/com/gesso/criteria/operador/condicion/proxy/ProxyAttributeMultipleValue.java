/**
 * 
 */
package ec.com.gesso.criteria.operador.condicion.proxy;

import javax.persistence.criteria.Predicate;

import org.apache.commons.lang3.ArrayUtils;

import ec.com.gesso.criteria.entity.attribute.basic.AttributeMultipleValue;
import ec.com.gesso.criteria.operador.condicion.Condicionable;

/**
 * @author gortiz
 *
 */
public class ProxyAttributeMultipleValue extends AbstractProxyField<AttributeMultipleValue> {
	
	public ProxyAttributeMultipleValue(Condicionable<AttributeMultipleValue> condicion) {
		super(condicion);
	}

	@Override
	public Predicate getPredicate(AttributeMultipleValue row) {
		final boolean existeCondicionable = condicion != null;
		final boolean existeRow = row != null;
		
		if ( existeCondicionable && existeRow && row.getNombreCampo() != null && ArrayUtils.isNotEmpty(row.getValues())){
			return this.condicion.getPredicate(row);
		}
		return null;
	}

}
