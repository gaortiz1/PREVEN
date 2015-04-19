/**
 * 
 */
package ec.com.gesso.criteria.where;

import java.io.Serializable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import org.apache.commons.collections4.CollectionUtils;

import ec.com.gesso.criteria.WrapperPredicable;
import ec.com.gesso.criteria.build.BuilderWrapperPredicable;
import ec.com.gesso.criteria.entity.attribute.basic.AttributeMultipleValue;
import ec.com.gesso.criteria.entity.attribute.basic.AttributeNoneValue;
import ec.com.gesso.criteria.entity.attribute.basic.AttributeOneValue;
import ec.com.gesso.criteria.entity.attribute.decorator.AttributeOperadoLogico;
import ec.com.gesso.criteria.operador.condicion.AbstractTemplateCriteria;
import ec.com.gesso.criteria.operador.condicion.enumeration.ComparacionEnum;
import ec.com.gesso.criteria.operador.condicion.enumeration.InterseccionEnum;
import ec.com.gesso.criteria.operador.condicion.factory.impl.OperadorMultipleValueFactory;
import ec.com.gesso.criteria.operador.condicion.factory.impl.OperadorNoneValueFactory;
import ec.com.gesso.criteria.operador.condicion.factory.impl.OperadorOneValueFactory;
import ec.com.gesso.criteria.operador.logico.impl.And;
import ec.com.gesso.criteria.read.entity.ReadableEntity;

/**
 * @author gortiz
 *
 */
public final class WhereEntity<T extends Serializable> extends AbstractTemplateCriteria implements WrapperPredicable {
	
	private final ReadableEntity readEntity;
	
	private WhereEntity(CriteriaBuilder criteriaBuilderWhere, Path<?> pathField, ReadableEntity readEntity) {
		super(criteriaBuilderWhere, pathField);
		this.readEntity = readEntity;
	}

	public static <T extends Serializable> WrapperPredicable where(final CriteriaBuilder criteriaBuilderWhere, final Path<?> pathField, final ReadableEntity readEntity) {
		return new WhereEntity<T>(criteriaBuilderWhere, pathField, readEntity);
	}

	public Predicate getPredicate() {
		
		BuilderWrapperPredicable builderOperadorLogico = null;
		
		if (CollectionUtils.isNotEmpty(readEntity.getBasicFields())){
			
			Predicate predicateField = null;
			
			builderOperadorLogico = new BuilderWrapperPredicable(And.andPredicate(criteriaBuilderWhere));
			
			for (final AttributeOperadoLogico<?, ?> attributeOperadoLogico : readEntity.getBasicFields()) {
				
				if (attributeOperadoLogico.getAttribute() instanceof AttributeOneValue) {
					
					predicateField = OperadorOneValueFactory
							.getInstance(criteriaBuilderWhere, pathField)
							.newInstance((ComparacionEnum) attributeOperadoLogico.getComparacionEnum())
							.getPredicate((AttributeOneValue) attributeOperadoLogico.getAttribute());
					
				} else if (attributeOperadoLogico.getAttribute() instanceof AttributeMultipleValue) {
					
					predicateField = OperadorMultipleValueFactory
							.getInstance(criteriaBuilderWhere, pathField)
							.newInstance((InterseccionEnum) attributeOperadoLogico.getComparacionEnum())
							.getPredicate((AttributeMultipleValue) attributeOperadoLogico.getAttribute());
					
				} else if (attributeOperadoLogico.getAttribute() instanceof AttributeNoneValue) {
					
					predicateField = OperadorNoneValueFactory
							.getInstance(criteriaBuilderWhere, pathField)
							.newInstance((InterseccionEnum) attributeOperadoLogico.getComparacionEnum())
							.getPredicate((AttributeNoneValue) attributeOperadoLogico.getAttribute());
				}
				
				builderOperadorLogico.addCondicion(predicateField);
			}
		}
		
		return builderOperadorLogico != null ? builderOperadorLogico.getPredicate() : null;
	}
	
}
