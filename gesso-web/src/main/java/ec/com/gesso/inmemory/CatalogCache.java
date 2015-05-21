package ec.com.gesso.inmemory;

import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Catalog;
import ec.com.gesso.security.application.ICatalogService;
import ec.com.gesso.security.factory.GessoSecurityFactory;

/**
 * 
 * @author Gabriel
 *
 */
public class CatalogCache extends AbstracCache  {
	
	private static final CatalogCache CATALOG_CACHE = new CatalogCache();
	
	private final ICatalogService catalogService;
	
	public static CatalogCache getInstance() {
		return CATALOG_CACHE;
	}
	
	/**
	 * @param catalogService
	 * @param gessoCache
	 */
	private CatalogCache() {
		super();
		this.catalogService = GessoSecurityFactory.getInstance().getCatalogService();
	}

	public Collection<Catalog> findCatalogByGroup(String idGroupCatalog) throws GessoException {
		if (!this.cache.existValue(idGroupCatalog)) {
			
			final Collection<Catalog> catalogs = this.catalogService.findCatalogByGroup(idGroupCatalog);
			
			if (CollectionUtils.isNotEmpty(catalogs)) {
				this.cache.put(idGroupCatalog, catalogs);
			} else {
				return CollectionUtils.EMPTY_COLLECTION;
			}
			
		}
		return (Collection<Catalog>) this.cache.get(idGroupCatalog);
	}

	public Collection<Catalog> findSexCatalog() throws GessoException {
		if (!this.cache.existValue("sex")) {
			
			final Collection<Catalog> catalogs = this.catalogService.findSexCatalog();
			
			if (CollectionUtils.isNotEmpty(catalogs)) {
				this.cache.put("sex", this.catalogService.findSexCatalog());
			} else {
				return CollectionUtils.EMPTY_COLLECTION;
			}
			
		}
		return (Collection<Catalog>) this.cache.get("sex");
	}

	public Collection<Catalog> findVulnerabilityCatalog() throws GessoException {
		if (!this.cache.existValue("vul")) {
			
			final Collection<Catalog> catalogs = this.catalogService.findVulnerabilityCatalog();
			
			if (CollectionUtils.isNotEmpty(catalogs)) {
				this.cache.put("vul", catalogs);
			} else {
				return CollectionUtils.EMPTY_COLLECTION;
			}
		}
		return (Collection<Catalog>) this.cache.get("vul");
	}

	public Collection<Catalog> findProfesionCatalog() throws GessoException {
		if (!this.cache.existValue("prof")) {
			
			final Collection<Catalog> catalogs = this.catalogService.findProfesionCatalog();
			
			if (CollectionUtils.isNotEmpty(catalogs)) {
				this.cache.put("prof", this.catalogService.findProfesionCatalog());
			} else {
				return CollectionUtils.EMPTY_COLLECTION;
			}
		}
		return (Collection<Catalog>) this.cache.get("prof");
	}

}
