/**
 * 
 */
package ec.com.gesso.application.service.impl;

import ec.com.gesso.application.service.IServiceEntity;
import ec.com.gesso.domain.IHandlerEntity;
import ec.com.gesso.model.entity.Process;

/**
 * @author Gabriel
 *
 */
public class ServiceProcess implements IServiceEntity<Process> {
	
	private IHandlerEntity<Process> handlerProcess;

	public Process register(final Process process) {
		return this.handlerProcess.register(process);
	}

	/**
	 * @param handlerProcess the handlerProcess to set
	 */
	public void setHandlerProcess(IHandlerEntity<Process> handlerProcess) {
		this.handlerProcess = handlerProcess;
	}
}