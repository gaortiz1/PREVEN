package ec.com.gesso.controller.serializer;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import ec.com.gesso.model.entity.SubProcess;

/**
 * @author roberto
 *
 */
public class SubProcessAdapter implements JsonSerializer<SubProcess> {

	@Override
	public JsonElement serialize(SubProcess subProcess, Type arg1, JsonSerializationContext arg2) {
		JsonObject processJsonObject = new JsonObject();
		processJsonObject.addProperty("id", subProcess.getId());
        processJsonObject.addProperty("text", subProcess.getName());
        
        return processJsonObject; 
	}
	
	
	
}
