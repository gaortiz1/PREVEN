package ec.com.gesso.criteria.operador.condicion.impl;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import ec.com.gesso.criteria.entity.attribute.basic.AttributeMultipleValue;
import ec.com.gesso.criteria.operador.condicion.AbstractTemplatePath;
import ec.com.gesso.criteria.operador.condicion.Condicionable;

/**
 * 
 * @author gortiz
 *
 */
public final class In extends AbstractTemplatePath implements Condicionable<AttributeMultipleValue> {
	
	private In(Path<?> pathField){
		super(pathField);
	}
	
	public static In inPredicate(final Path<?> pathField) {
        return new In(pathField);
    }

	@Override
	public Predicate getPredicate(final AttributeMultipleValue fieldMultipleValue) {
		return this.pathField.get(fieldMultipleValue.getNombreCampo()).in(fieldMultipleValue.getValues());
	}

}
