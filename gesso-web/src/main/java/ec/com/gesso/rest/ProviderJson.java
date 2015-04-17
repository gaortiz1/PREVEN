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

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.json.adapter.Adapter;
import ec.com.gesso.json.serializer.JobSerializer;
import ec.com.gesso.json.serializer.SubProcessSerializer;
import ec.com.gesso.model.entity.Job;
import ec.com.gesso.model.entity.SubProcess;
import ec.com.gesso.security.factory.GessoSecurityFactory;

/**
 * @author Gabriel
 *
 */
@RestController
public class ProviderJson implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@RequestMapping(value = "/sub-process/{idProcess}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public String loadSubProcess(@PathVariable Long idProcess, Model model) {
		
		Collection<SubProcess> levelVulnerability = null;
		try {
			levelVulnerability = GessoSecurityFactory.getInstance().getProcessService().findSubProcess(idProcess);
		} catch (GessoException e) {
			e.printStackTrace();
		}
		
    	return getGson(new Adapter(SubProcess.class, new SubProcessSerializer(), levelVulnerability));
    }
	
	@RequestMapping(value = "/jobs/{idSubProcess}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public String loadJobs(@PathVariable Long idSubProcess, Model model) {
		
		Collection<Job> levelVulnerability = null;
		try {
			levelVulnerability = GessoSecurityFactory.getInstance().getProcessService().findJobs(idSubProcess);
		} catch (GessoException e) {
			e.printStackTrace();
		}
		
    	return getGson(new Adapter(Job.class, new JobSerializer(), levelVulnerability));
    }
	
	private String getGson(final Adapter adapter){
		return new GsonBuilder().registerTypeAdapter(adapter.getType(), adapter.getJsonSerializer()).create().toJson(adapter.getSrc());
	}
}
