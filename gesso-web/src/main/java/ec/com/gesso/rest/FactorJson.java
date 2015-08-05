/**
 * 
 */
package ec.com.gesso.rest;

import java.io.Serializable;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.GsonBuilder;

import ec.com.gesso.inmemory.FactorCache;
import ec.com.gesso.json.adapter.Adapter;
import ec.com.gesso.json.serializer.FactorSerializer;
import ec.com.gesso.model.entity.Factor;

/**
 * @author Gabriel
 *
 */
@RestController
@RequestMapping
public class FactorJson implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@RequestMapping(value = "/factor/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String findFactorById(@PathVariable Long id) {
		Factor factor = FactorCache.getInstance().findFactorById(id);
		return getGson(new Adapter(Factor.class, new FactorSerializer(), factor));
    }
	
	@RequestMapping(value = "/factor", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public String findAllFactor() {
		return getGson(new Adapter(Factor.class, new FactorSerializer(), FactorCache.getInstance().findAllFactor()));
    }
	
	private String getGson(final Adapter adapter){
		return new GsonBuilder().registerTypeAdapter(adapter.getType(), adapter.getJsonSerializer()).create().toJson(adapter.getSrc());
	}
}
