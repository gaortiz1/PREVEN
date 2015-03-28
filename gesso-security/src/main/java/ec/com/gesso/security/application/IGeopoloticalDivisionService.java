package ec.com.gesso.security.application;

import java.util.Collection;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.GeopoliticalDivision;

/**
 * @author roberto
 *
 */
public interface IGeopoloticalDivisionService {
	
	public Collection<GeopoliticalDivision> findGeopoliticalDivision(Long idGeopoliticalDivision) throws GessoException;
	public Collection<GeopoliticalDivision> findRoorGeopoliticalDivision(Long idRootGeopoliticalDivision) throws GessoException;
	public Collection<GeopoliticalDivision> findAllGeopoliticalDivisionRoot() throws GessoException;
	

}
