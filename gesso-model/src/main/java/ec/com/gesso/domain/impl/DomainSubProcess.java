/**
 * 
 */
package ec.com.gesso.domain.impl;

import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.model.entity.Job;
import ec.com.gesso.model.entity.SubProcess;
import ec.com.gesso.repository.IRepositoryEntity;

/**
 * @author Gabriel
 *
 */
public class DomainSubProcess implements IDomainEntity<SubProcess> {
	
	private IRepositoryEntity<SubProcess> repositorySubProcess;
	private IDomainEntity<Job> domainJob;

	public SubProcess create(SubProcess subProcess) {
		
		this.repositorySubProcess.create(subProcess);
		
		if(subProcess.getSubLevels() != null && !subProcess.getSubLevels().isEmpty()) {
			
			for(final SubProcess subLevel : subProcess.getSubLevels()) {
				subLevel.setIdRoot(subProcess.getId());
				this.create(subLevel);
			}
		}
		
		if(subProcess.getJobs() != null && !subProcess.getJobs().isEmpty()) {
			
			for(final Job job : subProcess.getJobs()) {
				subProcess.setIdProcess(subProcess.getId());
				this.domainJob.create(job);
			}
		}
		
		return subProcess;
	}

	/**
	 * @param repositorySubProcess the repositorySubProcess to set
	 */
	public void setRepositorySubProcess(
			IRepositoryEntity<SubProcess> repositorySubProcess) {
		this.repositorySubProcess = repositorySubProcess;
	}

	/**
	 * @param domainJob the domainJob to set
	 */
	public void setDomainJob(IDomainEntity<Job> domainJob) {
		this.domainJob = domainJob;
	}
}
