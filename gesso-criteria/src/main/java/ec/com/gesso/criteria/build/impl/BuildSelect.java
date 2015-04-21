/**
 * 
 */
package ec.com.gesso.criteria.build.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import ec.com.gesso.criteria.build.BuildableSelect;
import ec.com.gesso.criteria.select.impl.SelectEntity;

/**
 * @author gortiz
 *
 */
public class BuildSelect implements BuildableSelect {
	
	private final EntityManager entityManager;
	private final CriteriaBuilder criteriaBuilder;
	
	public BuildSelect(EntityManager entityManager) {
		
		if (entityManager == null){
			throw new IllegalArgumentException("El entityManager no puede ser null");
		}
		
		this.entityManager = entityManager;
		this.criteriaBuilder = entityManager.getCriteriaBuilder();
	}

	public static BuildableSelect select(final EntityManager entityManager){
		return new BuildSelect(entityManager);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Serializable> CriteriaQuery<T> getCriteriaQuery(T entity) {
		
		CriteriaQuery<T> criteriaSelect = null;

		if (entity != null) {

			criteriaSelect = (CriteriaQuery<T>) criteriaBuilder.createQuery(entity.getClass());

			final Root<?> rootEntity = criteriaSelect.from(entity.getClass());

			final EntityType<?> entityType = rootEntity.getModel();
			
			final Predicate where = SelectEntity.select(criteriaBuilder, entityManager.getMetamodel()).getWhere(entity, rootEntity, entityType);

			if (where != null) {
				criteriaSelect.where(where);
			}
		}
		return criteriaSelect;
	}

}
