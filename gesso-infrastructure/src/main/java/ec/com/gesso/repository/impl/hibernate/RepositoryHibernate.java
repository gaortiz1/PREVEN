/**
 * 
 */
package ec.com.gesso.repository.impl.hibernate;

import java.io.Serializable;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.PropertyValueException;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

import ec.com.gesso.repository.IOperationEntity;
import ec.com.gesso.repository.exception.EntityDataValidationException;
import ec.com.gesso.repository.exception.GessoRepositoryException;

/**
 * @author Gabriel
 *
 */
public final class RepositoryHibernate<Entity extends Serializable> extends BaseHibernateRepository implements IOperationEntity<Entity> {
	
	private Session session;

	public Entity add(final Entity entity) {

		try {
			this.session.persist(entity);
			this.session.flush();
			return entity;
		} catch (IllegalArgumentException e) {
			throw new EntityDataValidationException("La entidad no puede ser null");
		} catch (MappingException e) {
			final StringBuilder builderMessageException = new StringBuilder();
			builderMessageException
					.append("La entidad no se encuentra mapeada")
					.append(StringUtils.SPACE)
					.append(entity.getClass().getName());
			throw new EntityDataValidationException(builderMessageException.toString());
		} catch (PropertyValueException e) {
			final StringBuilder builderMessageException = new StringBuilder();
			builderMessageException
					.append("La entidad no puede tener el campo")
					.append(StringUtils.SPACE)
					.append(e.getPropertyName())
					.append(StringUtils.SPACE)
					.append("null");
			throw new EntityDataValidationException(builderMessageException.toString());
		} catch (ConstraintViolationException e) {
			final StringBuilder builderMessageException = new StringBuilder();
			builderMessageException.append("La entidad")
					.append(StringUtils.SPACE)
					.append(entity.getClass().getName())
					.append(StringUtils.SPACE)
					.append("no tiene asociado un campo")
					.append(StringUtils.SPACE);
			throw new GessoRepositoryException(builderMessageException.toString(),e);
		} catch (HibernateException e){
			throw new GessoRepositoryException("Ocurrio un error al intentat crear", e);
		} catch (Exception e) {
			throw new GessoRepositoryException("Ocurrio un error al intentat crear", e);
		}
	}

	public Entity update(final Entity entity) {
		try {
			this.session.merge(entity);
			this.session.flush();
			return entity;
		} catch (IllegalArgumentException e) {
			throw new EntityDataValidationException("La entidad no puede ser null");
		} catch (MappingException e) {
			final StringBuilder builderMessageException = new StringBuilder();
			builderMessageException
					.append("La entidad no se encuentra mapeada")
					.append(StringUtils.SPACE)
					.append(entity.getClass().getName());
			throw new EntityDataValidationException(builderMessageException.toString());
		} catch (PropertyValueException e) {
			final StringBuilder builderMessageException = new StringBuilder();
			builderMessageException
					.append("La entidad no puede tener el campo")
					.append(StringUtils.SPACE)
					.append(e.getPropertyName())
					.append(StringUtils.SPACE)
					.append("null");
			throw new EntityDataValidationException(builderMessageException.toString());
		} catch (ConstraintViolationException e) {
			final StringBuilder builderMessageException = new StringBuilder();
			builderMessageException.append("La entidad")
					.append(StringUtils.SPACE)
					.append(entity.getClass().getName())
					.append(StringUtils.SPACE)
					.append("no tiene asociado un campo")
					.append(StringUtils.SPACE);
			throw new EntityDataValidationException(builderMessageException.toString(),e);
		} catch (HibernateException e){
			throw new GessoRepositoryException("Ocurrio un error al intentat crear", e);
		} catch (Exception e) {
			throw new GessoRepositoryException("Ocurrio un error al intentat crear", e);
		}
	}

	public Entity addOrUpdate(Entity entity) {
		try {
			this.session.saveOrUpdate(entity);
			this.session.flush();
			return entity;
		} catch (IllegalArgumentException e) {
			throw new EntityDataValidationException("La entidad no puede ser null");
		} catch (MappingException e) {
			final StringBuilder builderMessageException = new StringBuilder();
			builderMessageException
					.append("La entidad no se encuentra mapeada")
					.append(StringUtils.SPACE)
					.append(entity.getClass().getName());
			throw new EntityDataValidationException(builderMessageException.toString());
		} catch (PropertyValueException e) {
			final StringBuilder builderMessageException = new StringBuilder();
			builderMessageException
					.append("La entidad no puede tener el campo")
					.append(StringUtils.SPACE)
					.append(e.getPropertyName())
					.append(StringUtils.SPACE)
					.append("null");
			throw new EntityDataValidationException(builderMessageException.toString());
		} catch (ConstraintViolationException e) {
			final StringBuilder builderMessageException = new StringBuilder();
			builderMessageException.append("La entidad")
					.append(StringUtils.SPACE)
					.append(entity.getClass().getName())
					.append(StringUtils.SPACE)
					.append("no tiene asociado un campo")
					.append(StringUtils.SPACE);
			throw new EntityDataValidationException(builderMessageException.toString(),e);
		} catch (HibernateException e){
			throw new GessoRepositoryException("Ocurrio un error al intentat crear", e);
		} catch (Exception e) {
			throw new GessoRepositoryException("Ocurrio un error al intentat crear", e);
		}
	}
	
	/**
	 * @param session the session to set
	 */
	public void setSession(EntityManagerFactory entityManagerFactory) {
		this.session = entityManagerFactory.createEntityManager().unwrap(Session.class);
	}
}
