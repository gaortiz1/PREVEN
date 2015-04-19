package ec.com.gesso.json.serializer;

import java.lang.reflect.Type;

import org.apache.commons.collections.CollectionUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import ec.com.gesso.model.entity.Job;
import ec.com.gesso.model.entity.Process;
import ec.com.gesso.model.entity.SubProcess;

/**
 * @author roberto
 *
 */
public class ProcessSerializer implements JsonSerializer<Process> {

	@Override
	public JsonElement serialize(Process process, Type arg1, JsonSerializationContext arg2) {
		JsonObject processJsonObject = new JsonObject();
        processJsonObject.addProperty("text", process.getName());
        
        if(CollectionUtils.isEmpty(process.getSubProcesses())){
        	processJsonObject.addProperty("type", "item");
        }else{
        	processJsonObject.addProperty("type", "folder");
        }
        
        processJsonObject.addProperty("id", process.getId());
        
        JsonArray jsonSubprocesSlices = new JsonArray();
        JsonArray jsonJobSlices = new JsonArray();
        JsonObject jsonObjectAdditionalParametersSubProcess = new JsonObject();
        JsonObject jsonObjectAdditionalParametersJob = new JsonObject();
        
        if(process.getSubProcesses() != null){
        	
        	for(SubProcess subProcess: process.getSubProcesses()){
        		JsonObject subProcesoJsonObject = new JsonObject();
        		
        		subProcesoJsonObject.addProperty("id", subProcess.getId());
        		subProcesoJsonObject.addProperty("text", subProcess.getName());
        		if(CollectionUtils.isEmpty(subProcess.getJobs())){
        			subProcesoJsonObject.addProperty("type", "item");
    	        }else{
    	        	subProcesoJsonObject.addProperty("type", "folder");
    	        }
        		
        		
        		if(CollectionUtils.isNotEmpty(subProcess.getJobs())){
        			JsonObject jobJsonObject = new JsonObject();
        			for(Job job: subProcess.getJobs()){
        				jobJsonObject.addProperty("id", job.getId());
        				jobJsonObject.addProperty("text", job.getName());
        				jobJsonObject.addProperty("type", "item");
        				jsonJobSlices.add(jobJsonObject);
        			}
        			jsonObjectAdditionalParametersJob.add("children", jsonJobSlices);
        			subProcesoJsonObject.add("additionalParameters", jsonObjectAdditionalParametersJob);
        		}
        		
        		jsonSubprocesSlices.add(subProcesoJsonObject);
        	}
        }
        
        
        jsonObjectAdditionalParametersSubProcess.add("children", jsonSubprocesSlices);
        
        processJsonObject.add("additionalParameters", jsonObjectAdditionalParametersSubProcess);
        return processJsonObject; 
	}
	
	
	
}