/**
 * 
 */
package ec.com.gesso.application.factory;

import org.springframework.context.ApplicationContext;

/**
 * @author Gabriel
 *
 */
public abstract class BaseFactorySpring {
	
	private final ApplicationContext applicationContext;

	/**
	 * @param applicationContext
	 */
	protected BaseFactorySpring(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	
	protected Object getBean(String name) {
		return this.applicationContext.getBean(name);
	}
	
	<T> T getBean(String name, Class<T> requiredType) {
		return this.applicationContext.getBean(name, requiredType);
	}

}
