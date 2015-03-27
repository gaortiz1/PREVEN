package ec.com.gesso.security.application;

import java.util.Collection;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Process;

/**
 * @author roberto
 *
 */
public interface IProcessService {
	public Collection<Process> findProcess() throws GessoException;
}
