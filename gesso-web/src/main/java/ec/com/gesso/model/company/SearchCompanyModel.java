/**
 * 
 */
package ec.com.gesso.model.company;

import java.io.Serializable;
import java.util.Collection;

import ec.com.gesso.model.entity.Company;

/**
 * @author Gabriel
 *
 */
public class SearchCompanyModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Collection<Company> companies;

	/**
	 * @return the companies
	 */
	public Collection<Company> getCompanies() {
		return companies;
	}

	/**
	 * @param companies the companies to set
	 */
	public void setCompanies(Collection<Company> companies) {
		this.companies = companies;
	}
	
}
