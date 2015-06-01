package ec.com.gesso.json.serializer;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import ec.com.gesso.model.entity.Catalog;

/**
 * @author roberto
 *
 */
public class CatalogSerializer implements JsonSerializer<Catalog> {

	@Override
	public JsonElement serialize(Catalog catalog, Type type, JsonSerializationContext arg2) {
		JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", catalog.getId());
        jsonObject.addProperty("name", catalog.getName());
        return jsonObject; 
	}
}
