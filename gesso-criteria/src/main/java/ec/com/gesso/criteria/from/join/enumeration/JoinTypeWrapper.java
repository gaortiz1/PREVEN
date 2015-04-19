/**
 * 
 */
package ec.com.gesso.criteria.from.join.enumeration;

import javax.persistence.criteria.JoinType;

/**
 * @author gortiz
 * 
 */
public final class JoinTypeWrapper {

	public static final JoinTypeWrapper INNER = new JoinTypeWrapper(JoinType.INNER);
	public static final JoinTypeWrapper LEFT = new JoinTypeWrapper(JoinType.LEFT);
	public static final JoinTypeWrapper RIGHT = new JoinTypeWrapper(JoinType.RIGHT);
	
	private final JoinType joinType;

	private JoinTypeWrapper(JoinType joinType) {
		this.joinType = joinType;
	}

	public JoinType getJoinType() {
		return joinType;
	}
}
