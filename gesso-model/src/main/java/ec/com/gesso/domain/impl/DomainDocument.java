/**
 * 
 */
package ec.com.gesso.domain.impl;

import ec.com.gesso.domain.IDomainEntity;
import ec.com.gesso.model.entity.Document;
import ec.com.gesso.repository.IRepositoryEntity;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class DomainDocument implements IDomainEntity<Document> {
	
	private IRepositoryEntity<Document> repositoryDocument;

	public Document create(final Document document) {
		
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
		
		return this.repositoryDocument.create(document);
	}

	/**
	 * @param repositoryDocument the repositoryDocument to set
	 */
	public void setRepositoryDocument(IRepositoryEntity<Document> repositoryDocument) {
		this.repositoryDocument = repositoryDocument;
	}
}
