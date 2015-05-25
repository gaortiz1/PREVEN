package ec.com.gesso.repository.impl;

import ec.com.gesso.criteria.QueryCriteria;
import ec.com.gesso.model.entity.Risk;
import ec.com.gesso.repository.IOperationEntity;
import ec.com.gesso.repository.IRepositoryRisk;

/**
 * 
 * @author Gabriel
 *
 */
public final class RepositoryRisk extends RepositoryGenericEntity<Risk> implements IRepositoryRisk {

	public RepositoryRisk(IOperationEntity<Risk> operationEntity, QueryCriteria queryCriteria) {
		super(operationEntity, queryCriteria);
	}

	@Override
	public Risk findById(Long id) {
		final Risk risk = new Risk();
		risk.setId(id);
		risk.setState(Boolean.TRUE);
		return this.find(risk);
	}
	
	
}
