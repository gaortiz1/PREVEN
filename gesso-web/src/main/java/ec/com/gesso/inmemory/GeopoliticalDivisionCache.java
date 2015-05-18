/**
 * 
 */
package ec.com.gesso.inmemory;

import java.util.Collection;

import ec.com.gesso.application.factory.GessoSearchCriteriaFactory;
import ec.com.gesso.application.service.IServiceCriteria;
import ec.com.gesso.model.entity.GeopoliticalDivision;

/**
 * @author Gabriel
 *
 */
public class GeopoliticalDivisionCache extends AbstracCache {
	
	private static final GeopoliticalDivisionCache GEOPOLITICAL_DIVISION_CACHE = new GeopoliticalDivisionCache();
	private final IServiceCriteria serviceCriteria;
	
	public static GeopoliticalDivisionCache getInstance() {
		return GEOPOLITICAL_DIVISION_CACHE;
	}
	
	/**
	 * @param catalogService
	 * @param gessoCache
	 */
	private GeopoliticalDivisionCache() {
		super();
		this.serviceCriteria = GessoSearchCriteriaFactory.getInstance().getServiceCriteria();
	}
	
	public Collection<GeopoliticalDivision> findRootGeopoliticalDivision() {
		if (!this.cache.existValue("root")) {
			this.cache.put("root", this.serviceCriteria.findRootGeopoliticalDivision());
		}
		return (Collection<GeopoliticalDivision>) this.cache.get("root");
    }
	
	public Collection<GeopoliticalDivision> findGeopoliticalDivisionRoot(final Long idRoot) {
		
		final GeopoliticalDivision geopoliticalDivision = new GeopoliticalDivision();
		geopoliticalDivision.setState(Boolean.TRUE);
		geopoliticalDivision.setIdRoot(idRoot);
		
		if (!this.cache.existValue(idRoot)) {
			this.cache.put(idRoot, this.serviceCriteria.findAll(geopoliticalDivision));
		}
		return (Collection<GeopoliticalDivision>) this.cache.get(idRoot);
    }
	
	public Collection<GeopoliticalDivision> findGeopoliticalDivisionById(final Long id) {

		final GeopoliticalDivision geopoliticalDivision = new GeopoliticalDivision();
		geopoliticalDivision.setState(Boolean.TRUE);
		geopoliticalDivision.setId(id);

		if (!this.cache.existValue(id)) {
			this.cache.put(id, this.serviceCriteria.findAll(geopoliticalDivision));
		}
		return (Collection<GeopoliticalDivision>) this.cache.get(id);
	}
}
