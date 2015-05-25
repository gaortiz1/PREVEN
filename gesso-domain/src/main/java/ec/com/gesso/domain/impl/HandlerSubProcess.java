/**
 * 
 */
package ec.com.gesso.domain.impl;

import ec.com.gesso.domain.IHandlerEntity;
import ec.com.gesso.model.entity.Job;
import ec.com.gesso.model.entity.SubProcess;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class HandlerSubProcess extends BaseHandlerEntity<SubProcess> {
	
	private IHandlerEntity<Job> handlerJob;

	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.domain.IHandlerEntity#register(java.io.Serializable)
	 */
	public SubProcess register(SubProcess subProcess) {
		this.validarSubProcess(subProcess);
		
		if (subProcess.getId() == null) {
			subProcess.setState(Boolean.TRUE);
			this.repositoryEntity.add(subProcess);
		} else {
			this.repositoryEntity.update(subProcess);
		}
		
		if(subProcess.getSubLevels() != null && !subProcess.getSubLevels().isEmpty()) {
			
			for(final SubProcess subLevel : subProcess.getSubLevels()) {
				subLevel.setIdRoot(subProcess.getId());
				this.register(subLevel);
			}
		}
		
		if(subProcess.getJobs() != null && !subProcess.getJobs().isEmpty()) {
			
			for(final Job job : subProcess.getJobs()) {
				subProcess.setIdProcess(subProcess.getId());
				this.handlerJob.register(job);
			}
		}
		
		return subProcess;
	}
	
	private void validarSubProcess(final SubProcess subProcess){
		if (null == subProcess) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		
		if (null == subProcess.getIdProcess()) {
			throw new ValidationEntity("El campo id process no puede ser null");
		}
		
		if (null == subProcess.getName()) {
			throw new ValidationEntity("El campo name no puede ser null");
		}
		
		if (null == subProcess.getDescription()) {
			throw new ValidationEntity("El campo description no puede ser null");
		}
	}

	/**
	 * @param handlerJob the handlerJob to set
	 */
	public void setHandlerJob(IHandlerEntity<Job> handlerJob) {
		this.handlerJob = handlerJob;
	}
}
