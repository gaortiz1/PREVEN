/**
 * 
 */
package ec.com.gesso.domain.impl;

import ec.com.gesso.model.entity.Job;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class DomainJob extends BaseDomainEntity<Job> {

	public Job create(final Job job) {
		
		if (null == job) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		if (null == job.getName()) {
			throw new ValidationEntity("El campo name es null");
		}
		
		if (null == job.getDescription()) {
			throw new ValidationEntity("El campo Description es null");
		}
		
		job.setState(Boolean.TRUE);
		
		this.repositoryEntity.create(job);
		
		if(job.getSubLevels() != null && !job.getSubLevels().isEmpty()) {
			
			for(final Job subLevel : job.getSubLevels()) {
				subLevel.setIdRoot(job.getId());
				this.create(subLevel);
			}
		}
		return job;
	}
}
