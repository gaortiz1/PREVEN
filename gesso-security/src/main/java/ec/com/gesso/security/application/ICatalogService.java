package ec.com.gesso.security.application;

import java.util.Collection;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Catalog;

/**
 * @author roberto
 *
 */
public interface ICatalogService {
	
	public Collection<Catalog> findCatalogByGroup(Integer idGroupCatalog) throws GessoException;
	public Collection<Catalog> findSexCatalog() throws GessoException;
	public Collection<Catalog> findVulnerabilityCatalog() throws GessoException;
	

}
