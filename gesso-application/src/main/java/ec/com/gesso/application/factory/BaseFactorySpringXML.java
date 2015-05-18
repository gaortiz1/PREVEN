/**
 * 
 */
package ec.com.gesso.application.factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Gabriel
 *
 */
public abstract class BaseFactorySpringXML extends BaseFactorySpring {
	
	/**
	 * @param applicationContext
	 */
	protected BaseFactorySpringXML(final String... configLocations) {
		super(new ClassPathXmlApplicationContext(configLocations));
	}
}
