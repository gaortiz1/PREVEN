/**
 * 
 */
package ec.com.gesso.criteria.read.entity;

import java.util.Set;

import ec.com.gesso.criteria.entity.attribute.decorator.AttributeJoin;
import ec.com.gesso.criteria.entity.attribute.decorator.AttributeOperadoLogico;

/**
 * @author gortiz
 *
 */
public interface ReadableEntity {
	
	Set<AttributeOperadoLogico<?,?>> getBasicFields();
	
	Set<AttributeJoin<?>> getBeanFields();
	
}