package ec.com.gesso.inmemory;

import java.util.Collection;

import ec.com.gesso.application.cache.ICacheable;
import ec.com.gesso.application.factory.GessoCacheFactory;
import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Catalog;
import ec.com.gesso.security.application.ICatalogService;
import ec.com.gesso.security.factory.GessoSecurityFactory;

/**
 * 
 * @author Gabriel
 *
 */
public class CatalogCache {
	
	private static final CatalogCache CATALOG_CACHE = new CatalogCache();
	
	private ICatalogService catalogService;
	private ICacheable cache;
	
	public static CatalogCache getInstance() {
		return CATALOG_CACHE;
	}
	

	/**
	 * @param catalogService
	 * @param gessoCache
	 */
	private CatalogCache() {
		this.catalogService = GessoSecurityFactory.getInstance().getCatalogService();
		this.cache = GessoCacheFactory.getInstance().getServiceGessoCache();
	}

	public Collection<Catalog> findCatalogByGroup(String idGroupCatalog) throws GessoException {
		if (!this.cache.existValue(idGroupCatalog)) {
			this.cache.put(idGroupCatalog, this.catalogService.findCatalogByGroup(idGroupCatalog));
		}
		return (Collection<Catalog>) this.cache.get(idGroupCatalog);
	}

	public Collection<Catalog> findSexCatalog() throws GessoException {
		if (!this.cache.existValue("sex")) {
			this.cache.put("sex", this.catalogService.findSexCatalog());
		}
		return (Collection<Catalog>) this.cache.get("sex");
	}

	public Collection<Catalog> findVulnerabilityCatalog() throws GessoException {
		if (!this.cache.existValue("vul")) {
			this.cache.put("vul", this.catalogService.findVulnerabilityCatalog());
		}
		return (Collection<Catalog>) this.cache.get("vul");
	}

	public Collection<Catalog> findProfesionCatalog() throws GessoException {
		if (!this.cache.existValue("prof")) {
			this.cache.put("prof", this.catalogService.findProfesionCatalog());
		}
		return (Collection<Catalog>) this.cache.get("prof");
	}

}
