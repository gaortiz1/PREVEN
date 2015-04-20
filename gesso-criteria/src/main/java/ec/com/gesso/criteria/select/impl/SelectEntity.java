/**
 * 
 */
package ec.com.gesso.criteria.select.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import org.apache.commons.collections4.CollectionUtils;

import ec.com.gesso.criteria.WrapperPredicable;
import ec.com.gesso.criteria.build.BuilderWrapperPredicable;
import ec.com.gesso.criteria.entity.attribute.basic.AttributeOneValue;
import ec.com.gesso.criteria.entity.attribute.decorator.AttributeJoin;
import ec.com.gesso.criteria.from.fetch.impl.FetchEntityLazy;
import ec.com.gesso.criteria.read.entity.ReadEntity;
import ec.com.gesso.criteria.read.entity.ReadableEntity;
import ec.com.gesso.criteria.select.Select;
import ec.com.gesso.criteria.where.WhereEntity;

/**
 * @author gortiz
 *
 */
public final class SelectEntity implements Select {
	
	private final CriteriaBuilder criteriaBuilder;
	private final Metamodel metamodel;
	
	private SelectEntity(CriteriaBuilder criteriaBuilder, Metamodel metamodel) {
		this.criteriaBuilder = criteriaBuilder;
		this.metamodel = metamodel;
	}


	public static Select select(final CriteriaBuilder criteriaBuilder, final Metamodel metamodel) {
		return new SelectEntity(criteriaBuilder, metamodel);
	}


	@SuppressWarnings("unchecked")
	public <T extends Serializable> WrapperPredicable getWhere(final T entity, final From<?, ?> from, final EntityType<?> entityType) {
		
		BuilderWrapperPredicable builderWhere = null;
		ReadableEntity readEntity = null;
		
		readEntity = ReadEntity.read(entityType, entity, criteriaBuilder);
		builderWhere = new BuilderWrapperPredicable(WhereEntity.where(criteriaBuilder, from, readEntity));;
		
		final Set<AttributeJoin<?>> fieldsWithObject = readEntity.getBeanFields();
		
		if (CollectionUtils.isNotEmpty(fieldsWithObject)) {
			
			for (final AttributeJoin<?> fieldObjectJoin : fieldsWithObject) {
				
				EntityType<?> entityTypeJoin = null;
				T entityJoin = null;
				From<?, ?> join = null;
				
				if (fieldObjectJoin.getAttribute() instanceof AttributeOneValue){
					
					join = FetchEntityLazy.join(from).getFrom((AttributeJoin<AttributeOneValue>) fieldObjectJoin);
					
					final AttributeOneValue attributeOneValue = (AttributeOneValue) fieldObjectJoin.getAttribute();
			
					
					if (attributeOneValue.getValue() instanceof Collection) {
						
						final Collection<?> collection = (Collection<?>) attributeOneValue.getValue();
						
						if (CollectionUtils.isNotEmpty(collection)) {
							entityTypeJoin = buildEntityType(collection.iterator().next());
						}
						
					} else {
						entityTypeJoin = buildEntityType(attributeOneValue.getValue());
					}
					
					builderWhere.addCondicion(this.getWhere(entityJoin, join, entityTypeJoin));
					
				}
			}
			
		}
		
		return builderWhere;
	}
	
	
	private EntityType<?> buildEntityType(Object entity){
		return this.metamodel.entity(entity.getClass());
	}
	
}
