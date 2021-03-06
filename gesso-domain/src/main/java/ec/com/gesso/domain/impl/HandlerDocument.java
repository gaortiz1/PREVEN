/**
 * 
 */
package ec.com.gesso.domain.impl;

import ec.com.gesso.model.entity.Document;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class HandlerDocument extends BaseHandlerEntity<Document> {
	
	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.domain.IHandlerEntity#register(java.io.Serializable)
	 */
	public Document register(final Document document) {
		
		this.validateDocument(document);
		
		if (document.getState() == null){
			document.setState(Boolean.TRUE);
		}
		
		return this.repositoryEntity.addOrUpdate(document);
	}
	
	private void validateDocument(final Document document) {
		if (null == document) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		
		if (null == document.getIdDocument()) {
			throw new ValidationEntity("El id del document es null");
		}
		
		if (null == document.getValue()) {
			throw new ValidationEntity("El campo value es null");
		}
		
		if (null == document.getIdDocument().getIdTypeDocument()) {
			throw new ValidationEntity("El type document es null");
		}
		
		if (document.getIdCompany() == null && document.getIdPerson() == null) {
			throw new ValidationEntity("El documento no pertenece ni a persona ni a compania");
		}
		
		if(document.getIdCompany() != null && document.getIdPerson() != null) {
			throw new ValidationEntity("El documento no puede pertenecer a persona y a una compania");
		}
		
		
		if(document.getIdCompany() != null && document.getIdDocument() != null){
			document.getIdDocument().setIdDocument(document.getIdCompany());
		}
		
		if(document.getIdPerson() != null && document.getIdDocument() != null){
			document.getIdDocument().setIdDocument(document.getIdPerson());
		}
	}
}
