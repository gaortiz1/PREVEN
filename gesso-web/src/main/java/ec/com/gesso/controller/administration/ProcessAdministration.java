package ec.com.gesso.controller.administration;

import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.controller.serializer.ProcessAdapter;
import ec.com.gesso.controller.serializer.SubProcessAdapter;
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
    public ModelAndView processAdministration(){
    	ProcessView processView = new ProcessView();
    	try {
			processView.setLstProcess(GessoSecurityFactory.getInstance().getProcessService().findProcess());
		} catch (GessoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        ModelAndView modelAndView = new ModelAndView("process-administration", "command", processView);
        modelAndView.addObject("lstProcess", processView.getLstProcess());
        return modelAndView;
    }
    
    @RequestMapping(value = "/new-process", method = RequestMethod.POST)
    public ModelAndView newProcess(@ModelAttribute("contact")ProcessView processView, BindingResult result){
    	
        ModelAndView modelAndView = new ModelAndView("process-administration", "command", processView);
        
        try {
			GessoSecurityFactory.getInstance().getProcessService().persisNewProcess(processView.getProcess());
		} catch (GessoException e) {
			e.printStackTrace();
		}
        return modelAndView;
    }
    
    @RequestMapping(value = "/new-subprocess", method = RequestMethod.POST)
    public ModelAndView newSubProcess(@ModelAttribute("contact")ProcessView processView, BindingResult result){
        ModelAndView modelAndView = new ModelAndView("process-administration", "command", processView);
        
        try {
			GessoSecurityFactory.getInstance().getProcessService().persisNewSubProcess(processView.getSubProcess());
		} catch (GessoException e1) {
			e1.printStackTrace();
		}
        
        
        modelAndView.addObject("lstProcess", loadProcess());
        return modelAndView;
    }
    
    private Collection<Process> loadProcess(){
    	try {
    		return GessoSecurityFactory.getInstance().getProcessService().findProcess();
    	} catch (GessoException e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    } 
    
    @RequestMapping(value = "/new-job", method = RequestMethod.POST)
    public ModelAndView newJob(@ModelAttribute("contact")ProcessView processView, BindingResult result){
        ModelAndView modelAndView = new ModelAndView("process-administration", "command", processView);
        try {
			GessoSecurityFactory.getInstance().getProcessService().persisNewJob(processView.getJob());
		} catch (GessoException e) {
			e.printStackTrace();
		}
        
        modelAndView.addObject("lstProcess", loadProcess());
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
	    Gson gson = gsonBuilder.registerTypeAdapter(SubProcess.class, new SubProcessAdapter()).create();
	    
	    String valor = gson.toJson(levelVulnerability); 
    	return valor;
    }
   
}
