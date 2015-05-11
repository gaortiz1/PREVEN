/**
 * 
 */
package ec.com.gesso.repository.impl;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.PropertyValueException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

import ec.com.gesso.repository.IRepositoryEntity;
import ec.com.gesso.repository.exception.EntityDataValidationException;
import ec.com.gesso.repository.exception.GessoRepositoryException;

/**
 * @author Gabriel
 *
 */
public class RepositoryWrapperHibernate<Entity extends Serializable> extends BaseHibernateRepository implements IRepositoryEntity<Entity> {

	public RepositoryWrapperHibernate(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public Entity create(final Entity entity) {

		try {
			this.getSession().persist(entity);
			this.getSession().flush();
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

	public void edit(final Entity entity) {
		try {
			final Session session = this.getSession();
			session.merge(entity);
			session.flush();
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

	@Override
	public void saveOrUpdate(Entity entity) {
		try {
			final Session session = this.getSession();
			session.saveOrUpdate(entity);
			session.flush();
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

}
