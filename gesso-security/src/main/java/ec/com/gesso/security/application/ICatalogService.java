package ec.com.gesso.security.application;

import java.util.Collection;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.security.domain.model.security.dto.Catalog;

/**
 * @author roberto
 *
 */
public interface ICatalogService {
	
	public Collection<Catalog> findCatalogByGroup() throws GessoException;
	public Collection<Catalog> findSexCatalog() throws GessoException;
	public Collection<Catalog> findVulnerabilityCatalog() throws GessoException;
	

}
