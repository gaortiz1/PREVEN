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

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.inmemory.CatalogCache;
import ec.com.gesso.json.serializer.CatalogSerializer;
import ec.com.gesso.model.entity.Catalog;

/**
 * @author Gabriel
 *
 */
@RestController
@RequestMapping(value = "/catalog")
public class ProviderJsonCatalog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CatalogSerializer catalogSerializer;
	
	/**
	 * @param geopoliticalDivisionSerializer
	 */
	public ProviderJsonCatalog() {
		this.catalogSerializer = new CatalogSerializer();
	}
	
	@RequestMapping(value = "/group/{idGroupCatalog}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public String findCatalogByGroup(@PathVariable String idGroupCatalog, Model model) throws GessoException {
		
		final Collection<Catalog> catalogs = CatalogCache.getInstance().findCatalogByGroup(idGroupCatalog);
		GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.registerTypeAdapter(Catalog.class, catalogSerializer).create();
	    
    	return gson.toJson(catalogs); 
    }
}