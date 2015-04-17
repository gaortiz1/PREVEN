package ec.com.gesso.json.serializer;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import ec.com.gesso.model.entity.GeopoliticalDivision;

/**
 * @author roberto
 *
 */
public class GeopoliticalDivisionSerializer implements JsonSerializer<GeopoliticalDivision> {

	@Override
	public JsonElement serialize(final GeopoliticalDivision geopoliticalDivision, Type arg1, JsonSerializationContext arg2) {
		JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", geopoliticalDivision.getId());
        jsonObject.addProperty("idRoot", geopoliticalDivision.getIdRoot());
        jsonObject.addProperty("name", geopoliticalDivision.getName());
        return jsonObject; 
	}
}
