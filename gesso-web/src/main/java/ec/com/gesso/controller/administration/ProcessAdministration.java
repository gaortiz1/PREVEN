package ec.com.gesso.controller.administration;

import java.lang.reflect.Type;
import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Catalog;
import ec.com.gesso.model.entity.Process;
import ec.com.gesso.security.factory.GessoSecurityFactory;

/**
 * Created by roberto on 25/03/2015.
 */

@Controller
@SessionAttributes
public class ProcessAdministration {

    @RequestMapping(value = "/process-administration", method = RequestMethod.GET)
    public ModelAndView userAdministration(){
        ec.com.gesso.model.entity.Process process = new Process();
        ModelAndView modelAndView = new ModelAndView("process-administration", "command", process);

        Collection<Process> lstProcess = null;
		try {
			lstProcess = GessoSecurityFactory.getInstance().getProcessService().findProcess();
		} catch (GessoException e) {
			e.printStackTrace();
		}
		
		GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.registerTypeAdapter(Process.class, new ProcessAdapter()).create();
	    
    	String string = gson.toJson(lstProcess);
		
		System.out.println(string);
        modelAndView.addObject("lstProcess", lstProcess);
        return modelAndView;
    }
    
    @RequestMapping(value = "/load-process", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public String fillCiudad(Model model) {
		
		Collection<Process> levelVulnerability = null;
		try {
			levelVulnerability = GessoSecurityFactory.getInstance().getProcessService().findProcess();
		} catch (GessoException e) {
			e.printStackTrace();
		}
		
		GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.registerTypeAdapter(Process.class, new ProcessAdapter()).create();
	    
    	return gson.toJson(levelVulnerability);
    }
    
    class ProcessAdapter implements JsonSerializer<Process> {

		@Override
		public JsonElement serialize(Process arg0, Type arg1, JsonSerializationContext arg2) {
			JsonObject jsonObject = new JsonObject();
	        jsonObject.addProperty("text", arg0.getName());
	        jsonObject.addProperty("type", "folder");
	        
	        JsonObject jsonObjectw = new JsonObject();
	        jsonObjectw.add(arg0.getName(), jsonObject);
	        
	        return jsonObject; 
		}
	}
}
