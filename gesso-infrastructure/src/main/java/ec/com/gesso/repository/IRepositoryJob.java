/**
 * 
 */
package ec.com.gesso.repository;

import ec.com.gesso.model.entity.Job;


/**
 * @author Gabriel
 *
 */
public interface IRepositoryJob extends IRepositoryEntity<Job> {
	
	Job findById(Long id);
}
