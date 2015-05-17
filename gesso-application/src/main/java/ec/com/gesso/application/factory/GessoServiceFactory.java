package ec.com.gesso.application.factory;

import ec.com.gesso.application.service.IServiceEntity;
import ec.com.gesso.model.entity.Company;
import ec.com.gesso.model.entity.Process;

/**
 * 
 * @author Gabriel
 *
 */
public final class GessoServiceFactory extends BaseFactorySpringXML {

	private static final GessoServiceFactory GESSO_FACTORY = new GessoServiceFactory();

	private GessoServiceFactory() {
		super("classpath:ec/com/gesso/application/resource/spring/config/gesso-application.xml",
				"classpath:ec/com/gesso/application/resource/spring/config/gesso-persistencia-hibernate.xml",
				"classpath:ec/com/gesso/application/resource/spring/config/gesso-transactions.xml",
				"classpath:ec/com/gesso/domain/resource/spring/config/gesso-domain.xml",
				"classpath:ec/com/gesso/persistence/resources/spring/config/gesso-repository.xml",
				"classpath:ec/com/gesso/domain/resource/spring/config/gesso-mail.xml");
	}

	/**
	 * @return the gessoFactory
	 */
	public static GessoServiceFactory getInstance() {
		return GESSO_FACTORY;
	}

	public IServiceEntity<Company> getServiceCompany() {
		return this.getBean("serviceCompanyProxy", IServiceEntity.class);
	}

	public IServiceEntity<Process> getServiceProcess() {
		return this.getBean("serviceProcess", IServiceEntity.class);
	}

}
