/**
 * 
 */
package ec.com.gesso.application.service.impl;

import ec.com.gesso.application.service.IServiceEntity;
import ec.com.gesso.domain.IHandlerEntity;
import ec.com.gesso.model.entity.JobRisk;

/**
 * @author Gabriel
 *
 */
public class ServiceJobRisk implements IServiceEntity<JobRisk> {
	
	private IHandlerEntity<JobRisk> handlerJobRisk;

	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.application.service.IServiceEntity#create(java.io.Serializable)
	 */
	public JobRisk register(final JobRisk jobRisk) {
		return this.handlerJobRisk.register(jobRisk);
	}

	/**
	 * @param handlerJobRisk the handlerJobRisk to set
	 */
	public void setHandlerJobRisk(IHandlerEntity<JobRisk> handlerJobRisk) {
		this.handlerJobRisk = handlerJobRisk;
	}
}