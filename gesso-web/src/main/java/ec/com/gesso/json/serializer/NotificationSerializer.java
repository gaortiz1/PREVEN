/**
 * 
 */
package ec.com.gesso.json.serializer;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import ec.com.gesso.model.notification.Message;
import ec.com.gesso.model.notification.Notification;

/**
 * @author Gabriel
 *
 */
public class NotificationSerializer implements JsonSerializer<Notification> {

	@Override
	public JsonElement serialize(final Notification notification, final Type typeOfSrc, final JsonSerializationContext context) {
		
		final JsonObject jsonObjectNotification = new JsonObject();
		
		final JsonArray jsonArrayErrors =new JsonArray();
        for (Message message : notification.getWarnings()) {
        	final JsonObject messageJsonObject = new JsonObject();
        	messageJsonObject.addProperty("message", message.getMessage());
        	jsonArrayErrors.add(messageJsonObject);
		}
        
        jsonObjectNotification.add("errors", jsonArrayErrors);
        
        final JsonArray jsonArrayWarnings =new JsonArray();
        for (Message message : notification.getErrors()) {
        	final JsonObject messageJsonObject = new JsonObject();
        	messageJsonObject.addProperty("message", message.getMessage());
        	jsonArrayErrors.add(messageJsonObject);
		}
        
        jsonObjectNotification.add("warnings", jsonArrayWarnings);
        return jsonObjectNotification; 
	}

}
