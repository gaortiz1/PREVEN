/**
 * 
 */
package ec.com.gesso.application.service.impl;

import ec.com.gesso.application.service.IServiceEntity;
import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.model.entity.Process;

/**
 * @author Gabriel
 *
 */
public class ServiceProcess implements IServiceEntity<Process> {
	
	private IDomainEntity<Process> domainProcess;

	public Process create(final Process process) {
		
		return this.domainProcess.create(process);
	}

	/**
	 * @param domainProcess the domainProcess to set
	 */
	public void setDomainProcess(IDomainEntity<Process> domainProcess) {
		this.domainProcess = domainProcess;
	}
}