package ec.com.gesso.repository.impl;

import ec.com.gesso.criteria.QueryCriteria;
import ec.com.gesso.model.entity.ProbabilityConsequence;
import ec.com.gesso.model.entity.ProbabilityConsequencePK;
import ec.com.gesso.repository.IOperationEntity;
import ec.com.gesso.repository.IRepositoryProbabilityConsequence;

/**
 * 
 * @author Gabriel
 *
 */
public final class RepositoryProbabilityConsequence extends RepositoryGenericEntity<ProbabilityConsequence> implements IRepositoryProbabilityConsequence {

	public RepositoryProbabilityConsequence(IOperationEntity<ProbabilityConsequence> operationEntity, QueryCriteria queryCriteria) {
		super(operationEntity, queryCriteria);
	}

	@Override
	public ProbabilityConsequence findById(ProbabilityConsequencePK id) {
		ProbabilityConsequence probabilityConsequence = new ProbabilityConsequence();
		probabilityConsequence.setId(id);
		probabilityConsequence.setState(Boolean.TRUE);
		return this.find(probabilityConsequence);
	}
	
	
}
