/**
 * 
 */
package ec.com.gesso.repository;

import ec.com.gesso.model.entity.Risk;


/**
 * @author Gabriel
 *
 */
public interface IRepositoryRisk extends IRepositoryEntity<Risk> {
	
	Risk findById(Long id);
}
