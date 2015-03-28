package ec.com.gesso.security.domain.model.geopoliticalDivisionRepository;

import java.util.Collection;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.GeopoliticalDivision;

/**
 * @author roberto
 *
 */
public interface IGeopoliticalDivisionRepository {
	public Collection<GeopoliticalDivision> findGeopoliticalDivision(Long idGeopoliticalDivision) throws GessoException;
	public Collection<GeopoliticalDivision> findRoorGeopoliticalDivision(Long idRootGeopoliticalDivision) throws GessoException;
	public Collection<GeopoliticalDivision> findAllGeopoliticalDivisionRoot() throws GessoException;
}
