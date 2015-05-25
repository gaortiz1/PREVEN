/**
 * 
 */
package ec.com.gesso.domain.impl;

import ec.com.gesso.model.entity.JobRisk;
import ec.com.gesso.model.entity.ProbabilityConsequencePK;
import ec.com.gesso.repository.IRepositoryJob;
import ec.com.gesso.repository.IRepositoryProbabilityConsequence;
import ec.com.gesso.repository.IRepositoryRisk;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class HandlerJobRisk extends BaseHandlerEntity<JobRisk> {
	
	private IRepositoryProbabilityConsequence repositoryProbabilityConsequence;
	private IRepositoryJob repositoryJob;
	private IRepositoryRisk repositoryRisk;
	
	@Override
	public JobRisk register(final JobRisk jobRisk) {
		this.validarJobRisk(jobRisk);	
		
		if (null == this.repositoryJob.findById(jobRisk.getId().getIdJob())) {
			throw new ValidationEntity("Invalido id job");
		}
		
		if (null == this.repositoryRisk.findById(jobRisk.getId().getIdRisk())) {
			throw new ValidationEntity("Invalido id risk");
		}
		
		if (null == this.repositoryProbabilityConsequence.findById(new ProbabilityConsequencePK(jobRisk.getIdProbability(), jobRisk.getIdConsequence()))) {
			throw new ValidationEntity("Invalido id ProbabilityConsequence");
		}
		
		jobRisk.setState(Boolean.TRUE);
		
		return this.repositoryEntity.addOrUpdate(jobRisk);
	}
	
	private void validarJobRisk(final JobRisk jobRisk) {
		if (null == jobRisk) {
			throw new ValidationEntity("No se puede insert un email null");
		}
		
		if (null == jobRisk.getId()) {
			throw new ValidationEntity("El campo id es null");
		}
		
		if (null == jobRisk.getId().getIdJob()) {
			throw new ValidationEntity("El campo id Job es null");
		}
		
		if (null == jobRisk.getId().getIdRisk()) {
			throw new ValidationEntity("El campo id Risk es null");
		}
		
		if (null == jobRisk.getIdConsequence()) {
			throw new ValidationEntity("El campo id Consequence es null");
		}
		
		if (null == jobRisk.getIdProbability()) {
			throw new ValidationEntity("El campo id IdProbability es null");
		}
	}

	/**
	 * @param repositoryProbabilityConsequence the repositoryProbabilityConsequence to set
	 */
	public void setRepositoryProbabilityConsequence(IRepositoryProbabilityConsequence repositoryProbabilityConsequence) {
		this.repositoryProbabilityConsequence = repositoryProbabilityConsequence;
	}

	/**
	 * @param repositoryJob the repositoryJob to set
	 */
	public void setRepositoryJob(IRepositoryJob repositoryJob) {
		this.repositoryJob = repositoryJob;
	}

	/**
	 * @param repositoryRisk the repositoryRisk to set
	 */
	public void setRepositoryRisk(IRepositoryRisk repositoryRisk) {
		this.repositoryRisk = repositoryRisk;
	}
}
