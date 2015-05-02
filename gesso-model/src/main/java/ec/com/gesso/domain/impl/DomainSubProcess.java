/**
 * 
 */
package ec.com.gesso.domain.impl;

import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.model.entity.Job;
import ec.com.gesso.model.entity.SubProcess;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class DomainSubProcess extends BaseDomainEntity<SubProcess> {
	
	private IDomainEntity<Job> domainJob;

	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.domain.IDomainEntity#register(java.io.Serializable)
	 */
	public SubProcess register(SubProcess subProcess) {
		this.validarSubProcess(subProcess);
		
		if (subProcess.getId() == null) {
			subProcess.setState(Boolean.TRUE);
			this.repositoryEntity.create(subProcess);
		} else {
			this.repositoryEntity.edit(subProcess);
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
				this.domainJob.register(job);
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
	 * @param domainJob the domainJob to set
	 */
	public void setDomainJob(IDomainEntity<Job> domainJob) {
		this.domainJob = domainJob;
	}
}
