package ec.com.gesso.security.application.impl;

import java.util.Collection;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Catalog;
import ec.com.gesso.security.application.ICatalogService;
import ec.com.gesso.security.domain.model.catagog.ICatalogRepository;

/**
 * @author roberto
 *
 */
public class CatalogServiceImpl implements ICatalogService{
	
	private ICatalogRepository catalogRepository;

	public void setCatalogRepository(ICatalogRepository catalogRepository) {
		this.catalogRepository = catalogRepository;
	}

	@Override
	public Collection<Catalog> findCatalogByGroup(String idGroupCatalog) throws GessoException {
		return catalogRepository.findCatalogByGroup(idGroupCatalog);
	}

	@Override
	public Collection<Catalog> findSexCatalog() throws GessoException {
		return catalogRepository.findSexCatalog();
	}

	@Override
	public Collection<Catalog> findVulnerabilityCatalog() throws GessoException {
		return catalogRepository.findVulnerabilityCatalog();
	}

	@Override
	public Collection<Catalog> findProfesionCatalog() throws GessoException {
		return catalogRepository.findProfesionCatalog();
	}

}
