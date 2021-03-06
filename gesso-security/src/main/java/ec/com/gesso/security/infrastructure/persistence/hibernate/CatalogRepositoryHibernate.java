package ec.com.gesso.security.infrastructure.persistence.hibernate;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Catalog;
import ec.com.gesso.security.domain.model.catagog.ICatalogRepository;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

import java.util.Collection;

public class CatalogRepositoryHibernate extends HibernateRepository implements ICatalogRepository{

	@Override
	public Collection<Catalog> findCatalogByGroup(String idGroupCatalog) throws GessoException {
		
		Criteria criteria =  null;
		criteria = getSession().createCriteria(Catalog.class);
		criteria.createAlias("groupCatalog", "groupCatalogA");
		criteria.setFetchMode("groupCatalogA", FetchMode.JOIN);
		criteria.add(Restrictions.eq("idGroupcatalog", idGroupCatalog));
		
		return criteria.list();
	}

	@Override
	public Collection<Catalog> findSexCatalog() throws GessoException {
		return findCatalogByGroup("SEX");
	}

	@Override
	public Collection<Catalog> findVulnerabilityCatalog() throws GessoException {
		return findCatalogByGroup("NVUL");
	}

	@Override
	public Collection<Catalog> findProfesionCatalog() throws GessoException {
		return findCatalogByGroup("PRO");
	}

}
