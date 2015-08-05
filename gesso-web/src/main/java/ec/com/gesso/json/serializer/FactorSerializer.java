package ec.com.gesso.json.serializer;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import ec.com.gesso.model.entity.Factor;
import ec.com.gesso.model.entity.Risk;

/**
 * @author roberto
 *
 */
public class FactorSerializer implements JsonSerializer<Factor> {

	@Override
	public JsonElement serialize(Factor factor, Type type, JsonSerializationContext arg2) {
		JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", factor.getId());
        jsonObject.addProperty("name", factor.getName());
        
        JsonArray jsonIntList=new JsonArray();
        
        for (Risk risk : factor.getRisks()) {
        	jsonIntList.add(getJsonRisk(risk));
		}
        
        jsonObject.add("risks", jsonIntList);
        
        return jsonObject; 
	}
	
	public JsonObject getJsonRisk(Risk risk) {
		JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", risk.getId());
        jsonObject.addProperty("name", risk.getName());
        return jsonObject; 
	}
}
