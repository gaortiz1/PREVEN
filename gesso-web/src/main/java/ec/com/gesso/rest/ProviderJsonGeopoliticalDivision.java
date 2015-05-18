/**
 * 
 */
package ec.com.gesso.rest;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ec.com.gesso.application.factory.GessoSearchCriteriaFactory;
import ec.com.gesso.json.serializer.GeopoliticalDivisionSerializer;
import ec.com.gesso.model.entity.GeopoliticalDivision;

/**
 * @author Gabriel
 *
 */
@RestController
@RequestMapping(value = "/geopoliticaldivision")
public class ProviderJsonGeopoliticalDivision implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GeopoliticalDivisionSerializer geopoliticalDivisionSerializer;
	
	/**
	 * @param geopoliticalDivisionSerializer
	 */
	public ProviderJsonGeopoliticalDivision() {
		this.geopoliticalDivisionSerializer = new GeopoliticalDivisionSerializer();
	}

	@RequestMapping(value = "/root", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public String findGeopoliticalDivisionWitoutRoot(Model model) {
		
		final GeopoliticalDivision geopoliticalDivision = new GeopoliticalDivision();
		
		Collection<GeopoliticalDivision> collectionGeopoliticalDivisions = GessoSearchCriteriaFactory.getInstance().getServiceCriteria().findRootGeopoliticalDivision();
		
		GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.registerTypeAdapter(GeopoliticalDivision.class, geopoliticalDivisionSerializer).create();
	    
	    String valor = gson.toJson(collectionGeopoliticalDivisions); 
    	return valor;
    }
	
	@RequestMapping(value = "/children/{idRoot}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public String findGeopoliticalDivisionRoot(@PathVariable Long idRoot, Model model) {
		
		final GeopoliticalDivision geopoliticalDivision = new GeopoliticalDivision();
		geopoliticalDivision.setState(Boolean.TRUE);
		geopoliticalDivision.setIdRoot(idRoot);
		
		Collection<GeopoliticalDivision> collectionGeopoliticalDivisions = GessoSearchCriteriaFactory.getInstance().getServiceCriteria().findAll(geopoliticalDivision);
		
		GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.registerTypeAdapter(GeopoliticalDivision.class, geopoliticalDivisionSerializer).create();
	    
	    String valor = gson.toJson(collectionGeopoliticalDivisions); 
    	return valor;
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public String findGeopoliticalDivisionById(@PathVariable Long id, Model model) {
		
		final GeopoliticalDivision geopoliticalDivision = new GeopoliticalDivision();
		geopoliticalDivision.setState(Boolean.TRUE);
		geopoliticalDivision.setId(id);
		
		Collection<GeopoliticalDivision> collectionGeopoliticalDivisions = GessoSearchCriteriaFactory.getInstance().getServiceCriteria().findAll(geopoliticalDivision);
		
		GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.registerTypeAdapter(GeopoliticalDivision.class, geopoliticalDivisionSerializer).create();
	    
	    String valor = gson.toJson(collectionGeopoliticalDivisions); 
    	return valor;
    }
}