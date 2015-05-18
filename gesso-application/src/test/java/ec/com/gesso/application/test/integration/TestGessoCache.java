/**
 * 
 */
package ec.com.gesso.application.test.integration;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ec.com.gesso.application.cache.ICacheable;
import ec.com.gesso.application.factory.GessoCacheFactory;

/**
 * @author Gabriel
 *
 */
public class TestGessoCache {
	
	private ICacheable gessoCache;
	
	private final static String KEY = "key";
	
	@Before
	public void initGessoCache() {
		this.gessoCache = GessoCacheFactory.getInstance().getServiceGessoCache();
	}
	
	@Test
	public void shouldNotBeNullGessoCache(){
		assertNotNull(this.gessoCache);
	}
	
	@Test
	public void shouldPutKey(){
		this.gessoCache.put(KEY, new Object());
	}
	
	@Test
	public void shouldGetKeyWithObject(){
		assertNotNull(this.gessoCache.get(KEY));
	}
	
	@Test
	public void shouldExistValue(){
		assertTrue(this.gessoCache.existValue(KEY));
	}
	
	@Test
	public void shouldRemoveKey(){
		this.gessoCache.remove(KEY);
	}
	
	@Test
	public void shouldNotExistValue(){
		assertFalse(this.gessoCache.existValue(KEY));
	}
}
