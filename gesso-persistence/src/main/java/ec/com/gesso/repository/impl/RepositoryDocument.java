	/**
 * 
 */
package ec.com.gesso.repository.impl;

import ec.com.gesso.model.entity.Document;
import ec.com.gesso.repository.IRepositoryEntity;
import ec.com.gesso.repository.exception.ValidationEntity;

/**
 * @author Gabriel
 *
 */
public class RepositoryDocument implements IRepositoryEntity<Document> {

	private IRepositoryEntity<Document> repositoryEntity;

	/*
	 * (non-Javadoc)
	 * @see ec.com.gesso.repository.IRepositoryEntity#create(java.io.Serializable)
	 */
	public Document create(final Document document) {
		
		if (null == document) {
			throw new ValidationEntity("No se puede insert un valor null");
		}
		
		if (null == document.getIdDocument()) {
			throw new ValidationEntity("El id del es null");
		}
		
		if (null == document.getValue()) {
			throw new ValidationEntity("El campo value es null");
		}
		
		if (null == document.getIdDocument().getIdTypeDocument()) {
			throw new ValidationEntity("El type document es null");
		}
		
		document.setState(Boolean.TRUE);
		
		return this.repositoryEntity.create(document);
	}

	/**
	 * @param repositoryEntity the repositoryEntity to set
	 */
	public void setRepositoryEntity(IRepositoryEntity<Document> repositoryEntity) {
		this.repositoryEntity = repositoryEntity;
	}

}
