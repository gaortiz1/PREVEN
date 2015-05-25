/**
 * 
 */
package ec.com.gesso.application.factory;

import ec.com.gesso.application.service.IServiceCriteria;

/**
 * @author Gabriel
 *
 */
public final class GessoSearchCriteriaFactory extends BaseFactorySpringXML {
	
	private static final GessoSearchCriteriaFactory SEARCH_CRITERIA = new GessoSearchCriteriaFactory();
	
	private GessoSearchCriteriaFactory() {
		super("classpath:ec/com/gesso/persistence/resources/spring/config/gesso-repository.xml",
				"classpath:ec/com/gesso/application/resource/spring/config/gesso-data-source.xml", 
				"classpath:ec/com/gesso/application/resource/spring/config/gesso-criteria.xml", 
				"classpath:ec/com/gesso/application/resource/spring/config/gesso-jpa.xml",
				"classpath:ec/com/gesso/application/resource/spring/config/gesso-transactions.xml");
	}

	/**
	 * @return the gessoFactory
	 */
	public static GessoSearchCriteriaFactory getInstance() {
		return SEARCH_CRITERIA;
	}
	
	public IServiceCriteria getServiceCriteria(){
		return this.getBean("serviceCriteria",IServiceCriteria.class);
	}

}
