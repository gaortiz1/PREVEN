/**
 * 
 */
package ec.com.gesso.inmemory;

import java.util.Collection;
import java.util.Collections;

import org.apache.commons.collections4.CollectionUtils;

import ec.com.gesso.application.factory.GessoSearchCriteriaFactory;
import ec.com.gesso.model.entity.Risk;

/**
 * @author Gabriel
 *
 */
public class RiskCache extends AbstracCache {
	
	private static final RiskCache FACTOR_CACHE = new RiskCache();
	
	public static RiskCache getInstance() {
		return FACTOR_CACHE;
	}
	
	/**
	 * @param catalogService
	 * @param gessoCache
	 */
	private RiskCache() {
		super();
	}
	
	public Collection<Risk> findAllRisk() {
		
		if (!this.cache.existValue("risks")) {
			
			final Risk riskTemplate = new Risk();
			riskTemplate.setState(Boolean.TRUE);
			
			final Collection<Risk> risks = GessoSearchCriteriaFactory.getInstance().getServiceCriteria().findAll(riskTemplate);
			
			if(CollectionUtils.isNotEmpty(risks)) {
				this.cache.put("risks", risks);
			} else {
				return Collections.emptyList();
			}
			
		} 
		return (Collection<Risk>) this.cache.get("risks");
    }
	
	public Collection<Risk> findAllRiskByFactorId(Long idFactor) {
		
		if (!this.cache.existValue(idFactor + "risks")) {
			
			final Risk riskTemplate = new Risk();
			riskTemplate.setIdFactor(idFactor);	
			riskTemplate.setState(Boolean.TRUE);
			
			final Collection<Risk> risks = GessoSearchCriteriaFactory.getInstance().getServiceCriteria().findAll(riskTemplate);
			
			if(CollectionUtils.isNotEmpty(risks)) {
				this.cache.put(idFactor + "risks", risks);
			} else {
				return Collections.emptyList();
			}
			
		} 
		return (Collection<Risk>) this.cache.get(idFactor + "risks");
    }
	
	public Risk findRiskById(final Long id) {
		
		
		if (!this.cache.existValue(id)) {
			
			final Risk riskTemplate = new Risk();
			riskTemplate.setId(id);
			riskTemplate.setState(Boolean.TRUE);	
			
			final Risk risk = GessoSearchCriteriaFactory.getInstance().getServiceCriteria().find(riskTemplate);
			
			if (null != risk) {
				this.cache.put(id, risk);
			} else {
				return null;
			}
			
		}
		return (Risk) this.cache.get(id);
    }
}
