package ec.com.gesso.security.domain.model.catagog;

import java.util.Collection;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Catalog;

/**
 * @author roberto
 *
 */
public interface ICatalogRepository {
	public Collection<Catalog> findCatalogByGroup(String idGroupCatalog) throws GessoException;
	public Collection<Catalog> findSexCatalog() throws GessoException;
	public Collection<Catalog> findVulnerabilityCatalog() throws GessoException;
}
