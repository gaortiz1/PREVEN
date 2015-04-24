package ec.com.gesso.controller.administration.company;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ec.com.gesso.application.factory.GessoSearchCriteria;
import ec.com.gesso.model.company.SearchCompanyModel;
import ec.com.gesso.model.entity.Catalog;
import ec.com.gesso.model.entity.Company;
import ec.com.gesso.model.entity.GeopoliticalDivision;

@Controller
@SessionAttributes
public class SearchCompanyController {
	
	@RequestMapping(value = "/company-administration", method = RequestMethod.GET)
	public ModelAndView searchAllCompanies(){
		
		final Company company = new Company();
		company.setState(Boolean.TRUE);
		company.setCatalogSectorProductivo(new Catalog());
		company.setTypeCompany(new Catalog());
		company.setGeopoliticalDivision(new GeopoliticalDivision());
		
		final Collection<Company> companies = GessoSearchCriteria.getInstance().getServiceCriteria().findAll(company);
		
		final ModelAndView modelAndViewCompanies = new ModelAndView("company-administration", "command", new SearchCompanyModel());
		modelAndViewCompanies.addObject("companies", companies);
		return modelAndViewCompanies;
	}

}
