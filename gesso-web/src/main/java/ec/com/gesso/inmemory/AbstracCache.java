package ec.com.gesso.inmemory;

import ec.com.gesso.application.cache.ICacheable;
import ec.com.gesso.application.factory.GessoCacheFactory;

/**
 * 
 * @author Gabriel
 *
 */
public abstract class AbstracCache {
	
	protected final ICacheable cache;
	/**
	 * @param catalogService
	 * @param cache
	 */
	protected AbstracCache() {
		this.cache = GessoCacheFactory.getInstance().getServiceGessoCache();
	}
	
	public final void clearCache(){
		this.cache.clearCache();
	}

}
