package ec.com.gesso.controller.administration;

import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.json.serializer.ProcessSerializer;
import ec.com.gesso.json.serializer.SubProcessSerializer;
import ec.com.gesso.model.entity.Job;
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

	@RequestMapping(value = "/saveProcess_json", method = RequestMethod.POST)
	public  @ResponseBody Process savePerson_JSON( @RequestBody Process process ) throws Exception {
		GessoSecurityFactory.getInstance().getProcessService().persisNewProcess(process);
		return process;
	}

    
    @RequestMapping(value = "/saveSubProcess_json", method = RequestMethod.POST)
    public @ResponseBody SubProcess newSubProcess(@RequestBody SubProcess subProcess){
        
        try {
        	subProcess.setIdProcess(subProcess.getProcessRoot().getId());
			GessoSecurityFactory.getInstance().getProcessService().persisNewSubProcess(subProcess);
		} catch (GessoException e1) {
			e1.printStackTrace();
		}
        return subProcess;
    }
    
    
    @RequestMapping(value = "/saveJob_json", method = RequestMethod.POST)
    public @ResponseBody Job newJob(@RequestBody Job job) throws GessoException{
        
        
        	job.setIdSubProcess(job.getSubProcessRoot().getId());
        	GessoSecurityFactory.getInstance().getProcessService().persisNewJob(job);
		
        return job;
    }
    
    @RequestMapping(value = "/load-process_json", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Collection<Process> loadProcess() {
		
		Collection<Process> lstResultProces = null;
		try {
			lstResultProces = GessoSecurityFactory.getInstance().getProcessService().findProcess();
		} catch (GessoException e) {
			e.printStackTrace();
		}
		
		for(Process process: lstResultProces){
			process.setSubLevels(null);
			process.setSubProcesses(null);
			process.setLevelProcessRoot(null);
		}
    	return lstResultProces;
    }
    
    @RequestMapping(value = "/load-sub_processByPro_json", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Collection<SubProcess> loadSubProcessByProcess(@RequestBody Process value) {
    	
    	
    	Collection<SubProcess> lstSubProcessResult = null;
		try {
			lstSubProcessResult = GessoSecurityFactory.getInstance().getProcessService().findSubProcess(value.getId());
		} catch (GessoException e) {
			e.printStackTrace();
		}
		
    	return lstSubProcessResult;
    }
    
    
    @RequestMapping(value = "/load-process", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public String loadProcess(Model model) {
    	
		
		Collection<Process> lstResultProces = null;
		try {
			lstResultProces = GessoSecurityFactory.getInstance().getProcessService().findProcess();
		} catch (GessoException e) {
			e.printStackTrace();
		}
		
		GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.registerTypeAdapter(Process.class, new ProcessSerializer()).create();
	    String valor = gson.toJson(lstResultProces); 
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
	    Gson gson = gsonBuilder.registerTypeAdapter(SubProcess.class, new SubProcessSerializer()).create();
	    
	    String valor = gson.toJson(levelVulnerability); 
    	return valor;
    }
   
}
