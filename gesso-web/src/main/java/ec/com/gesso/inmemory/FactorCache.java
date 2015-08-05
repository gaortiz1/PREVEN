/**
 * 
 */
package ec.com.gesso.inmemory;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;

import ec.com.gesso.application.factory.GessoSearchCriteriaFactory;
import ec.com.gesso.model.entity.Factor;
import ec.com.gesso.model.entity.Risk;

/**
 * @author Gabriel
 *
 */
public class FactorCache extends AbstracCache {
	
	private static final FactorCache FACTOR_CACHE = new FactorCache();
	
	public static FactorCache getInstance() {
		return FACTOR_CACHE;
	}
	
	/**
	 * @param catalogService
	 * @param gessoCache
	 */
	private FactorCache() {
		super();
	}
	
	public Collection<Factor> findAllFactor() {
		
		if (!this.cache.existValue("factors")) {
			
			final Factor factorTemplate = new Factor();
			factorTemplate.setState(Boolean.TRUE);
			factorTemplate.setRisks(new ArrayList<Risk>());
			Risk risk = new Risk();
			risk.setState(Boolean.TRUE);
			factorTemplate.getRisks().add(risk);
			
			final Collection<Factor> factors = GessoSearchCriteriaFactory.getInstance().getServiceCriteria().findAll(factorTemplate);
			
			if(CollectionUtils.isNotEmpty(factors)) {
				this.cache.put("factors", factors);
			} else {
				return CollectionUtils.EMPTY_COLLECTION;
			}
			
		} 
		return (Collection<Factor>) this.cache.get("factors");
    }
	
	public Factor findFactorById(final Long id) {
		
		
		if (!this.cache.existValue(id)) {
			
			final Factor factorTemplate = new Factor();
			factorTemplate.setState(Boolean.TRUE);
			factorTemplate.setId(id);
			factorTemplate.setRisks(new ArrayList<Risk>());
			Risk risk = new Risk();
			risk.setState(Boolean.TRUE);
			factorTemplate.getRisks().add(risk);
			
			final Factor factor = GessoSearchCriteriaFactory.getInstance().getServiceCriteria().find(factorTemplate);
			
			if (null != factor) {
				this.cache.put(id, factor);
			} else {
				return null;
			}
			
		}
		return (Factor) this.cache.get(id);
    }
}
