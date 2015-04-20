/**
 * 
 */
package ec.com.gesso.criteria.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.QueryTimeoutException;
import javax.persistence.criteria.CriteriaQuery;

import ec.com.gesso.criteria.QueryCriteria;
import ec.com.gesso.criteria.build.BuildableSelect;
import ec.com.gesso.criteria.build.impl.BuildSelect;

/**
 * @author gortiz
 *
 */
public abstract class CriteriaJPA implements QueryCriteria {
	
	protected abstract EntityManager getEntityManager();
	
	/* (non-Javadoc)
	 * @see ec.gob.seps.query.criteria.Query#find(java.lang.Object)
	 */
	@Override
	public <T extends Serializable> T find(T entity) {
		
		try {
			
			if (entity != null) {
				final BuildableSelect select = BuildSelect.select(this.getEntityManager());
				final CriteriaQuery<T> criteriaQueryEntity = select.getCriteriaQuery(entity);
				return this.getEntityManager().createQuery(criteriaQueryEntity).getSingleResult();
			}
			
		} catch (NoResultException e){
			System.err.println(e);
		} catch (NonUniqueResultException e){
			System.err.println(e);
		} catch (QueryTimeoutException e) {
			System.err.println(e);
		} catch (Exception e) {
			System.err.println("A ocurrido un error al intentar buscar: " + e);
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see ec.gob.seps.query.criteria.Query#findAll(java.lang.Object)
	 */
	@Override
	public <T extends Serializable> Collection<T> findAll(T entity) {
		
		try {
			if (entity != null){
				final BuildableSelect select = BuildSelect.select(this.getEntityManager());
				final CriteriaQuery<T> criteriaQueryEntity = select.getCriteriaQuery(entity);
				criteriaQueryEntity.distinct(true);
				return this.getEntityManager().createQuery(criteriaQueryEntity).getResultList();
			}
		} catch (QueryTimeoutException e) {
			System.err.println(e);
		} catch (Exception e) {
			System.err.println("A ocurrido un error al intentar buscar: " + e);
		}
		
		return null;
	}

}
