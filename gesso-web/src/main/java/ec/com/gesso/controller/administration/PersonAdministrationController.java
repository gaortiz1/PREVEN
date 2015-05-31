package ec.com.gesso.controller.administration;

import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import ec.com.gesso.application.dto.UploadedFile;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.inmemory.CatalogCache;
import ec.com.gesso.json.serializer.CatalogSerializer;
import ec.com.gesso.model.entity.Catalog;
import ec.com.gesso.model.entity.CountryDto;
import ec.com.gesso.model.entity.Job;
import ec.com.gesso.model.entity.Person;
import ec.com.gesso.model.entity.Process;
import ec.com.gesso.model.entity.SubProcess;
import ec.com.gesso.security.factory.GessoSecurityFactory;

import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes
public class PersonAdministrationController {

    UploadedFile ufile;

    public PersonAdministrationController() {
        this.ufile = new UploadedFile();
    }

    @RequestMapping(value = "/person-administration", method = RequestMethod.GET)
	public ModelAndView userAdministration(){
		Collection<CountryDto> country = null;
		try {
			country = GessoSecurityFactory.getInstance().getLocalizationService().findCountry();
		} catch (GessoException e) {
			e.printStackTrace();
		}
		
		Collection<Catalog> levelVulnerability = null;

		Collection<Catalog> lstProfesion = null;

		Collection<Process> lstProcess = null;

		Person person = new Person();
		person.setStatusPerson(Boolean.TRUE);
        
		ModelAndView modelAndView = new ModelAndView("person-administration", "command", person);
		modelAndView.addObject("country", country);
		modelAndView.addObject("levelVulnerability",levelVulnerability);
		modelAndView.addObject("lstProfesion",lstProfesion);
		modelAndView.addObject("lstProcess",lstProcess);

		return modelAndView;
	}

	@RequestMapping(value = "/person-administration_json", method = RequestMethod.GET, produces={"application/xml", "application/json"})
	public @ResponseBody PersonAdministrationModel userAdministrationJson(){
		Collection<CountryDto> country = null;
		try {
			country = GessoSecurityFactory.getInstance().getLocalizationService().findCountry();
		} catch (GessoException e) {
			e.printStackTrace();
		}
		
		Collection<Catalog> levelVulnerability = null;
		try {
			levelVulnerability = CatalogCache.getInstance().findVulnerabilityCatalog();
			for(Catalog catalog: levelVulnerability){
				catalog.setGroupCatalog(null);
			}
			
		} catch (GessoException e) {
			e.printStackTrace();
		}
		
		Collection<Catalog> lstProfesion = null;
		try {
			lstProfesion = CatalogCache.getInstance().findProfesionCatalog();
			for(Catalog catalog: lstProfesion){
				catalog.setGroupCatalog(null);
			}
		} catch (GessoException e) {
			e.printStackTrace();
		}
		
		Collection<Process> lstProcess = null;
		try {
			lstProcess = GessoSecurityFactory.getInstance().getProcessService().findProcess();
			
			for(Process process: lstProcess){
				process.setSubProcesses(null);
			}
		} catch (GessoException e) {
			e.printStackTrace();
		}

		Person person = new Person();
		person.setStatusPerson(Boolean.TRUE);
        
		PersonAdministrationModel administrationModel = new PersonAdministrationModel();
		administrationModel.setCountry(country);
		administrationModel.setLevelVulnerability(levelVulnerability);
		administrationModel.setLstProcess(lstProcess);
		administrationModel.setLstProfesion(lstProfesion);
		administrationModel.setPerson(person);

		return administrationModel;
	}

	@RequestMapping(value = "/person-fill-ciudad/{petId}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public String fillCiudad(@PathVariable String petId, Model model) {
		Collection<Catalog> levelVulnerability = null;
		try {
			levelVulnerability = CatalogCache.getInstance().findVulnerabilityCatalog();
		} catch (GessoException e) {
			e.printStackTrace();
		}
		
		GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.registerTypeAdapter(Catalog.class, new CatalogSerializer()).create();
	    
    	return gson.toJson(levelVulnerability);
    }
	
	@RequestMapping(value = "/create-person_json", method = RequestMethod.POST)
    public @ResponseBody Person userAdministration(@RequestBody Person person) throws GessoException {
    	
    	person.setStatusPerson(Boolean.TRUE);
        person.setDateOfBirth(new Date());
    	GessoSecurityFactory.getInstance().getSecurityService().persistPerson(person);	
		
        return person;
    }
	
	@RequestMapping(value = "/person-load-sub-process/{idProcess}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Collection<SubProcess> loadSubProcess(@PathVariable Long idProcess) {
		
		Collection<SubProcess> lstSubProcess = null;
		try {
            lstSubProcess = GessoSecurityFactory.getInstance().getProcessService().findSubProcess(idProcess);
            if(CollectionUtils.isNotEmpty(lstSubProcess)) {
                for (SubProcess obj : lstSubProcess) {
                    obj.setProcessRoot(null);
                    obj.setJobs(null);
                }
            }
		} catch (GessoException e) {
			e.printStackTrace();
		}

    	return lstSubProcess;
    }
	
	@RequestMapping(value = "/person-load-jobs/{idSubProcess}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Collection<Job> loadJobs(@PathVariable Long idSubProcess) {
		
		Collection<Job> lstJob = null;
		try {
            lstJob = GessoSecurityFactory.getInstance().getProcessService().findJobs(idSubProcess);
            if(CollectionUtils.isNotEmpty(lstJob)) {
                for (Job obj : lstJob) {
                    System.out.println(obj);
                }
            }
		} catch (GessoException e) {
			e.printStackTrace();
		}
    	return lstJob;
    }


	@RequestMapping(value = "/get/{value}", method = RequestMethod.GET)
	public void get(HttpServletResponse response,@PathVariable String value){
		try {

			response.setContentType(ufile.type);
			response.setContentLength(ufile.length);
			FileCopyUtils.copy(ufile.bytes, response.getOutputStream());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody String upload(MultipartHttpServletRequest request, HttpServletResponse response) {

		//0. notice, we have used MultipartHttpServletRequest

		//1. get the file from the request object
		Iterator<String> itr =  request.getFileNames();

		MultipartFile mpf = request.getFile(itr.next());
		System.out.println(mpf.getOriginalFilename() +" uploaded!");

		try {
			ufile.length = mpf.getBytes().length;
			ufile.bytes= mpf.getBytes();
			ufile.type = mpf.getContentType();
			ufile.name = mpf.getOriginalFilename();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//2. send it back to the client as <img> that calls get method
		//we are using getTimeInMillis to avoid server cached image

		return "<img src='http://localhost:8080/spring-mvc-file-upload/rest/cont/get/"+ Calendar.getInstance().getTimeInMillis()+"' />";

	}
}


