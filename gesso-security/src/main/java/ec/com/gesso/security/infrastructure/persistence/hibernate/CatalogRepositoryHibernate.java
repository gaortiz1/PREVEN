package ec.com.gesso.security.infrastructure.persistence.hibernate;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Catalog;
import ec.com.gesso.security.domain.model.catagog.ICatalogRepository;

public class CatalogRepositoryHibernate extends HibernateRepository implements ICatalogRepository{

	@Override
	public Collection<Catalog> findCatalogByGroup(Integer idGroupCatalog) throws GessoException {
		
		Criteria criteria =  null;
		criteria =  getSession().createCriteria(Catalog.class);
		criteria.add(Restrictions.eq("idGroupcatalog", idGroupCatalog));
		
		Collection<Catalog> lst = null;
		
		try {
			lst = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lst;
	}

	@Override
	public Collection<Catalog> findSexCatalog() throws GessoException {
		return findCatalogByGroup(1);
	}

	@Override
	public Collection<Catalog> findVulnerabilityCatalog() throws GessoException {
		return findCatalogByGroup(2);
	}

}
