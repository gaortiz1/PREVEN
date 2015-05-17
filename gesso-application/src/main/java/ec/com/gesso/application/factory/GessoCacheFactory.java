package ec.com.gesso.application.factory;

import ec.com.gesso.application.cache.ICacheable;

/**
 * 
 * @author Gabriel
 *
 */
public final class GessoCacheFactory extends BaseFactorySpringXML {

	private static final GessoCacheFactory GESSO_FACTORY = new GessoCacheFactory();

	private GessoCacheFactory() {
		super("classpath:ec/com/gesso/application/resource/spring/config/gesso-cache.xml");
	}

	/**
	 * @return the gessoFactory
	 */
	public static GessoCacheFactory getInstance() {
		return GESSO_FACTORY;
	}

	public ICacheable getServiceGessoCache() {
		return this.getBean("gessoCache", ICacheable.class);
	}

}
