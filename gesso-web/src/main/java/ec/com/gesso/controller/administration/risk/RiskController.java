/**
 * 
 */
package ec.com.gesso.controller.administration.risk;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Gabriel
 *
 */
@Controller
@SessionAttributes
public class RiskController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@RequestMapping(value = "/risk/register-risk", method = RequestMethod.GET)
	public ModelAndView createRisk(){
		return new ModelAndView("/risk/register-risk");
	}

}
