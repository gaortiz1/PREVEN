package ec.com.gesso.json.serializer;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import ec.com.gesso.model.entity.Job;

public class JobSerializer implements JsonSerializer<Job>{

	@Override
	public JsonElement serialize(Job src, Type typeOfSrc, JsonSerializationContext context) {
		final JsonObject processJsonObject = new JsonObject();
		processJsonObject.addProperty("id", src.getId());
        processJsonObject.addProperty("text", src.getName());
        return processJsonObject; 
	}

}
