package ec.com.gesso.controller.serializer;

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
public class CatalogAdapter implements JsonSerializer<Catalog> {

	@Override
	public JsonElement serialize(Catalog arg0, Type arg1, JsonSerializationContext arg2) {
		JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("catalog_id", arg0.getId());
        jsonObject.addProperty("catalog_name", arg0.getName());
        return jsonObject; 
	}
}
