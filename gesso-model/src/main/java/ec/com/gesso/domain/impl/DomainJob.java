/**
 * 
 */
package ec.com.gesso.domain.impl;

import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.model.entity.Job;
import ec.com.gesso.repository.IRepositoryEntity;

/**
 * @author Gabriel
 *
 */
public class DomainJob implements IDomainEntity<Job> {
	
	private IRepositoryEntity<Job> repositoryJob;

	public Job create(final Job job) {
		
		this.repositoryJob.create(job);
		
		if(job.getSubLevels() != null && !job.getSubLevels().isEmpty()) {
			
			for(final Job subLevel : job.getSubLevels()) {
				subLevel.setIdRoot(job.getId());
				this.create(subLevel);
			}
		}
		return job;
	}

	/**
	 * @param repositoryJob the repositoryJob to set
	 */
	public void setRepositoryJob(IRepositoryEntity<Job> repositoryJob) {
		this.repositoryJob = repositoryJob;
	}

}
