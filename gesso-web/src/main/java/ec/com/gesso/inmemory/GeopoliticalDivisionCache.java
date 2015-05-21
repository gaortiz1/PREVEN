/**
 * 
 */
package ec.com.gesso.inmemory;

import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;

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
			
			final Collection<GeopoliticalDivision> geopoliticalDivisions = this.serviceCriteria.findRootGeopoliticalDivision();
			
			if(CollectionUtils.isNotEmpty(geopoliticalDivisions)) {
				this.cache.put("root", geopoliticalDivisions);
			} else {
				return CollectionUtils.EMPTY_COLLECTION;
			}
			
		} 
		return (Collection<GeopoliticalDivision>) this.cache.get("root");
    }
	
	public Collection<GeopoliticalDivision> findGeopoliticalDivisionRoot(final Long idRoot) {
		
		if (!this.cache.existValue(idRoot)) {
			
			final GeopoliticalDivision geopoliticalDivision = new GeopoliticalDivision();
			geopoliticalDivision.setState(Boolean.TRUE);
			geopoliticalDivision.setIdRoot(idRoot);
			
			final Collection<GeopoliticalDivision> geopoliticalDivisions = this.serviceCriteria.findAll(geopoliticalDivision);
			
			if (CollectionUtils.isNotEmpty(geopoliticalDivisions)) {
				this.cache.put(idRoot, this.serviceCriteria.findAll(geopoliticalDivision));
			} else {
				return CollectionUtils.EMPTY_COLLECTION;
			}
			
		}
		return (Collection<GeopoliticalDivision>) this.cache.get(idRoot);
    }
	
	public Collection<GeopoliticalDivision> findGeopoliticalDivisionById(final Long id) {

		if (!this.cache.existValue(id)) {
			
			final GeopoliticalDivision geopoliticalDivision = new GeopoliticalDivision();
			geopoliticalDivision.setState(Boolean.TRUE);
			geopoliticalDivision.setId(id);
			
			final Collection<GeopoliticalDivision> geopoliticalDivisions = this.serviceCriteria.findAll(geopoliticalDivision);
			
			if (CollectionUtils.isNotEmpty(geopoliticalDivisions)) {
				this.cache.put(id, this.serviceCriteria.findAll(geopoliticalDivision));
			} else {
				return CollectionUtils.EMPTY_COLLECTION;
			}
			
		} 
		return (Collection<GeopoliticalDivision>) this.cache.get(id);
	}
}
