/**
 * 
 */
package ec.com.gesso.criteria;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.QueryTimeoutException;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.log4j.Logger;

import ec.com.gesso.criteria.build.BuildableSelect;
import ec.com.gesso.criteria.build.impl.BuildSelect;

/**
 * @author gortiz
 *
 */
public abstract class BaseQueryCriteriaJPA extends AbstractCriteriaJPA implements QueryCriteria {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final static Logger LOG = Logger.getLogger(BaseQueryCriteriaJPA.class);
	
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
			e.printStackTrace();
		} catch (NonUniqueResultException e){
			System.err.println(e);
			e.printStackTrace();
		} catch (QueryTimeoutException e) {
			System.err.println(e);
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("A ocurrido un error al intentar buscar: " + e);
			e.printStackTrace();
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
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("A ocurrido un error al intentar buscar: ");
			e.printStackTrace();
		}
		
		return null;
	}

}
