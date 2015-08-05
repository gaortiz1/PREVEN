package ec.com.gesso.json.serializer;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import ec.com.gesso.model.entity.Risk;

/**
 * @author roberto
 *
 */
public class RiskSerializer implements JsonSerializer<Risk> {

	@Override
	public JsonElement serialize(Risk risk, Type type, JsonSerializationContext arg2) {
		JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", risk.getId());
        jsonObject.addProperty("name", risk.getName());
        return jsonObject; 
	}
}
