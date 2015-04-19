/**
 * 
 */
package ec.com.gesso.json.adapter;

import com.google.gson.JsonSerializer;

/**
 * @author Gabriel
 *
 */
public class Adapter {
	
	private final Class<?> type;
	private final JsonSerializer<?> jsonSerializer;
	private final Object src;
	/**
	 * @param type
	 * @param jsonSerializer
	 * @param src
	 */
	public Adapter(Class<?> type, JsonSerializer<?> jsonSerializer, Object src) {
		this.type = type;
		this.jsonSerializer = jsonSerializer;
		this.src = src;
	}
	/**
	 * @return the type
	 */
	public Class<?> getType() {
		return type;
	}
	/**
	 * @return the jsonSerializer
	 */
	public JsonSerializer<?> getJsonSerializer() {
		return jsonSerializer;
	}
	/**
	 * @return the src
	 */
	public Object getSrc() {
		return src;
	}
	

}
