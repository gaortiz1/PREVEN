/**
 * 
 */
package ec.com.gesso.application.cache.impl;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import ec.com.gesso.application.cache.ICacheable;

/**
 * @author Gabriel
 *
 */
public final class GessoCache implements ICacheable {

	private CacheManager cacheManager;

	public void put(final Object key, final Object value) {
		this.getCache().put(new Element(key, value));
	}
	
	public Object get(final Object key) {
		return this.getCache().get(key).getObjectValue();
	}
	
	public Boolean existValue(final Object key) {
		return this.getCache().isKeyInCache(key);
	}
	
	public void clearCache() {
		this.getCache().removeAll();
	}
	
	public void remove(final Object key) {
		this.getCache().remove(key);
	}
	
	private Cache getCache(){
		return this.cacheManager.getCache("gessoCache");
	}

	/**
	 * @param cacheManager the cacheManager to set
	 */
	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}
}
