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

import com.google.gson.GsonBuilder;

import ec.com.gesso.inmemory.RiskCache;
import ec.com.gesso.json.adapter.Adapter;
import ec.com.gesso.json.serializer.RiskSerializer;
import ec.com.gesso.model.entity.Risk;

/**
 * @author Gabriel
 *
 */
@RestController
@RequestMapping
public class RiskJson implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@RequestMapping(value = "/risk/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String findRiskById(@PathVariable Long id) {
		Risk risk = RiskCache.getInstance().findRiskById(id);
		return getGson(new Adapter(Risk.class, new RiskSerializer(), risk));
    }
	
	@RequestMapping(value = "/risk", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public String findAllFactor() {
		Collection<Risk> risks = RiskCache.getInstance().findAllRisk();		
		return getGson(new Adapter(Risk.class, new RiskSerializer(), risks));
    }
	
	
	@RequestMapping(value = "/risk/factor/{idFactor}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public String findAllFactor(@PathVariable Long idFactor, Model model) {
		Collection<Risk> risks = RiskCache.getInstance().findAllRiskByFactorId(idFactor);	
		return getGson(new Adapter(Risk.class, new RiskSerializer(), risks));
    }
	
	private String getGson(final Adapter adapter){
		return new GsonBuilder().registerTypeAdapter(adapter.getType(), adapter.getJsonSerializer()).create().toJson(adapter.getSrc());
	}
}
