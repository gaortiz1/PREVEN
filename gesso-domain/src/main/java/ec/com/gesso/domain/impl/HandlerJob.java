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
public class HandlerJob extends BaseHandlerEntity<Job> {
	
	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.domain.IHandlerEntity#register(java.io.Serializable)
	 */
	public Job register(final Job job) {
		this.validarJob(job);
		job.setState(Boolean.TRUE);
		if (job.getId() == null) {
			this.repositoryEntity.add(job);
		} else {
			this.repositoryEntity.update(job);
		}
		
		return job;
	}
	
	private void validarJob(final Job job) {
		if (null == job) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		if (null == job.getName()) {
			throw new ValidationEntity("El campo name es null");
		}
		
		if (null == job.getDescription()) {
			throw new ValidationEntity("El campo Description es null");
		}
	}
}
