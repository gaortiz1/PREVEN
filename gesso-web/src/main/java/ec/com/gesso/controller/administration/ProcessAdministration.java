package ec.com.gesso.controller.administration;

import java.lang.reflect.Type;
import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
import ec.com.gesso.model.entity.Process;
import ec.com.gesso.model.entity.SubProcess;
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
//	    Gson gson = gsonBuilder.registerTypeAdapter(Process.class, new ProcessAdapter()).create();
	    
//    	String string = gson.toJson(lstProcess);
		
//		System.out.println(string);
        modelAndView.addObject("lstProcess", lstProcess);
        return modelAndView;
    }
    
    @RequestMapping(value = "/load-process", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public String loadProcess(Model model) {
    	
		
		Collection<Process> levelVulnerability = null;
		try {
			levelVulnerability = GessoSecurityFactory.getInstance().getProcessService().findProcess();
		} catch (GessoException e) {
			e.printStackTrace();
		}
		
		GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.registerTypeAdapter(Process.class, new ProcessAdapter()).create();
	    String valor = gson.toJson(levelVulnerability); 
	    System.out.println(valor);
    	return valor;
    }
    
    
    @RequestMapping(value = "/load-sub-process/{idProcess}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public String loadSubProcess(@PathVariable Long idProcess, Model model) {
		
		Collection<SubProcess> levelVulnerability = null;
		try {
			levelVulnerability = GessoSecurityFactory.getInstance().getProcessService().findSubProcess(idProcess);
		} catch (GessoException e) {
			e.printStackTrace();
		}
		
		GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.registerTypeAdapter(SubProcess.class, new ProcessAdapter()).create();
	    
	    String valor = gson.toJson(levelVulnerability); 
    	return valor;
    }
    
    class ProcessAdapter implements JsonSerializer<Process> {

		@Override
		public JsonElement serialize(Process process, Type arg1, JsonSerializationContext arg2) {
			JsonObject processJsonObject = new JsonObject();
	        processJsonObject.addProperty("text", process.getName());
	        processJsonObject.addProperty("type", "folder");
	        processJsonObject.addProperty("id", process.getId());
	        
	        
	        JsonArray jsonSlices=new JsonArray();
	        if(process.getSubProcesses() != null){
	        	
	        	for(SubProcess subProcess: process.getSubProcesses()){
	        		JsonObject subProcesoJsonObject = new JsonObject();
	        		subProcesoJsonObject.addProperty("text", subProcess.getName());
	        		subProcesoJsonObject.addProperty("type", "folder");
	        		subProcesoJsonObject.addProperty("id", subProcess.getId());
	        		
	        		jsonSlices.add(subProcesoJsonObject);
	        	}
	        }
	        
	        JsonObject jsonObjectAdditionalParameters = new JsonObject();
	        jsonObjectAdditionalParameters.add("children", jsonSlices);
	        
	        
	        processJsonObject.add("additionalParameters", jsonObjectAdditionalParameters);
	        return processJsonObject; 
		}
	}
}
