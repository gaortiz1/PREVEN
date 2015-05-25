/**
 * 
 */
package ec.com.gesso.repository;

import ec.com.gesso.model.entity.ProbabilityConsequence;
import ec.com.gesso.model.entity.ProbabilityConsequencePK;


/**
 * @author Gabriel
 *
 */
public interface IRepositoryProbabilityConsequence extends IRepositoryEntity<ProbabilityConsequence> {
	
	public ProbabilityConsequence findById(ProbabilityConsequencePK id);
}
