package ec.com.gesso.repository.impl;

import ec.com.gesso.criteria.QueryCriteria;
import ec.com.gesso.model.entity.Job;
import ec.com.gesso.repository.IOperationEntity;
import ec.com.gesso.repository.IRepositoryJob;

/**
 * 
 * @author Gabriel
 *
 */
public final class RepositoryJob extends RepositoryGenericEntity<Job> implements IRepositoryJob {

	public RepositoryJob(IOperationEntity<Job> operationEntity, QueryCriteria queryCriteria) {
		super(operationEntity, queryCriteria);
	}

	@Override
	public Job findById(Long id) {
		final Job job = new Job();
		job.setId(id);
		job.setState(Boolean.TRUE);
		return this.find(job);
	}
	
	
}
