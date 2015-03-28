package ec.com.gesso.security.application.impl;

import java.util.Collection;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.GeopoliticalDivision;
import ec.com.gesso.security.application.IGeopoloticalDivisionService;
import ec.com.gesso.security.domain.model.geopoliticalDivisionRepository.IGeopoliticalDivisionRepository;

/**
 * @author roberto
 *
 */
public class GeopoliticalDivisionServiceImpl implements IGeopoloticalDivisionService{
	
	private IGeopoliticalDivisionRepository divisionRepository;

	@Override
	public Collection<GeopoliticalDivision> findGeopoliticalDivision(final Long idGeopoliticalDivision) throws GessoException {
		return divisionRepository.findGeopoliticalDivision(idGeopoliticalDivision);
	}

	@Override
	public Collection<GeopoliticalDivision> findRoorGeopoliticalDivision(final Long idRootGeopoliticalDivision) throws GessoException {
		return divisionRepository.findRoorGeopoliticalDivision(idRootGeopoliticalDivision);
	}

	@Override
	public Collection<GeopoliticalDivision> findAllGeopoliticalDivisionRoot() throws GessoException {
		return divisionRepository.findAllGeopoliticalDivisionRoot();
	}

	/**
	 * @param divisionRepository the divisionRepository to set
	 */
	public void setDivisionRepository(IGeopoliticalDivisionRepository divisionRepository) {
		this.divisionRepository = divisionRepository;
	}

}
