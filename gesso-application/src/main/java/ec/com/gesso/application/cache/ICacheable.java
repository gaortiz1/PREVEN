/**
 * 
 */
package ec.com.gesso.application.cache;

/**
 * @author Gabriel
 *
 */
public interface ICacheable {
	
	public void put(final Object key, final Object value);
	
	public Object get(final Object key);
	
	public Boolean existValue(final Object key);
	
	public void clearCache();
	
	public void remove(final Object key);

}
