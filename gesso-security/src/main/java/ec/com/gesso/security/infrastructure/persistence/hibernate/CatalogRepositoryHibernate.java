package ec.com.gesso.security.infrastructure.persistence.hibernate;

import java.util.Collection;

import org.hibernate.Criteria;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.security.domain.model.catagog.ICatalogRepository;
import ec.com.gesso.security.domain.model.security.dto.Catalog;

public class CatalogRepositoryHibernate extends HibernateRepository implements ICatalogRepository{

	@Override
	public Collection<Catalog> findCatalogByGroup(Integer idGroupCatalog) throws GessoException {
		
		Criteria criteria =  null;
		criteria =  getSession().createCriteria(Catalog.class);
//		criteria.add(Restrictions.eq("usrNickName", userName));
		return criteria.list();
	}

	@Override
	public Collection<Catalog> findSexCatalog() throws GessoException {
		return findCatalogByGroup(null);
	}

	@Override
	public Collection<Catalog> findVulnerabilityCatalog() throws GessoException {
		return findCatalogByGroup(null);
	}
	
	

}
