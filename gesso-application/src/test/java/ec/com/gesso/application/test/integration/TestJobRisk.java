/**
 * 
 */
package ec.com.gesso.application.test.integration;

import org.junit.Test;

import ec.com.gesso.application.factory.GessoServiceFactory;
import ec.com.gesso.application.lang.JobRiskBuilder;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class TestJobRisk {
	
	private JobRiskBuilder jobRiskBuilder = new JobRiskBuilder();
	
	@Test(expected=ValidationEntity.class)
	public void shouldNotRegisteJobRisk() {
		jobRiskBuilder.addIdConsequence("a").addIdJob(1l).addIdProbability("b").addIdRisk(1l).addState(Boolean.TRUE);
		GessoServiceFactory.getInstance().getServiceJobRisk().register(jobRiskBuilder.build());
	}
	
	@Test()
	public void shouldRegisteJobRisk() {
		jobRiskBuilder.addIdConsequence("LD").addIdJob(1l).addIdProbability("LOW").addIdRisk(1l).addState(Boolean.TRUE);
		GessoServiceFactory.getInstance().getServiceJobRisk().register(jobRiskBuilder.build());
	}

}
