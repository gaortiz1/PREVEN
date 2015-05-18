/**
 * 
 */
package ec.com.gesso.application.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ec.com.gesso.application.service.IServiceCriteria;
import ec.com.gesso.criteria.AbstractCriteriaJPA;
import ec.com.gesso.criteria.QueryCriteria;
import ec.com.gesso.model.entity.GeopoliticalDivision;

/**
 * @author Gabriel
 *
 */
public class ServiceCriteria extends AbstractCriteriaJPA implements IServiceCriteria {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private QueryCriteria queryCriteria;
	
	private EntityManager entityManager;

	public Collection<GeopoliticalDivision> findChildrenGeopoliticalDivision(Long idRoot) {
		
		final CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		final CriteriaQuery<GeopoliticalDivision> query = criteriaBuilder.createQuery(GeopoliticalDivision.class);
		final Root<GeopoliticalDivision> geopoliticalDivision = query.from(GeopoliticalDivision.class);
		query.select(geopoliticalDivision).where(criteriaBuilder.equal(geopoliticalDivision.get("idRoot"), idRoot));
		
		return this.entityManager.createQuery(query).getResultList();
	}

	public Collection<GeopoliticalDivision> findRootGeopoliticalDivision() {
		final CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		final CriteriaQuery<GeopoliticalDivision> query = criteriaBuilder.createQuery(GeopoliticalDivision.class);
		final Root<GeopoliticalDivision> geopoliticalDivision = query.from(GeopoliticalDivision.class);
		query.select(geopoliticalDivision).where(criteriaBuilder.isNull(geopoliticalDivision.get("idRoot")));
		
		return this.entityManager.createQuery(query).getResultList();
	}
	
	public Collection<GeopoliticalDivision> findGeopoliticalDivisionById(Long id) {
		final CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		final CriteriaQuery<GeopoliticalDivision> query = criteriaBuilder.createQuery(GeopoliticalDivision.class);
		final Root<GeopoliticalDivision> geopoliticalDivision = query.from(GeopoliticalDivision.class);
		query.select(geopoliticalDivision).where(criteriaBuilder.equal(geopoliticalDivision.get("id"), id));
		
		return this.entityManager.createQuery(query).getResultList();
	}

	public <T extends Serializable> T find(T entity) {
		return this.queryCriteria.find(entity);
	}

	public <T extends Serializable> Collection<T> findAll(T entity) {
		return this.queryCriteria.findAll(entity);
	}

	/**
	 * @param queryCriteria the queryCriteria to set
	 */
	public void setQueryCriteria(QueryCriteria queryCriteria) {
		this.queryCriteria = queryCriteria;
	}

	/**
	 * @param entityManager the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}