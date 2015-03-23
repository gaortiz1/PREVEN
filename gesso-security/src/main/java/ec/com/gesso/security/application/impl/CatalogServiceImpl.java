package ec.com.gesso.security.application.impl;

import java.util.Collection;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.security.application.ICatalogService;
import ec.com.gesso.security.domain.model.security.dto.Catalog;

/**
 * @author roberto
 *
 */
public class CatalogServiceImpl implements ICatalogService{

	@Override
	public Collection<Catalog> findCatalogByGroup() throws GessoException {
		return null;
	}

	@Override
	public Collection<Catalog> findSexCatalog() throws GessoException {
		return null;
	}

	@Override
	public Collection<Catalog> findVulnerabilityCatalog() throws GessoException {
		return null;
	}

}
