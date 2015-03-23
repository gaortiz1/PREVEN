package ec.com.gesso.security.domain.model.catagog;

import java.util.Collection;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.security.domain.model.security.dto.Catalog;

/**
 * @author roberto
 *
 */
public interface ICatalogRepository {
	public Collection<Catalog> findCatalogByGroup(Integer idGroupCatalog) throws GessoException;
	public Collection<Catalog> findSexCatalog() throws GessoException;
	public Collection<Catalog> findVulnerabilityCatalog() throws GessoException;
}
