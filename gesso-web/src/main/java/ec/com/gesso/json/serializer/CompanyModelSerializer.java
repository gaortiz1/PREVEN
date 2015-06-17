/**
 * 
 */
package ec.com.gesso.json.serializer;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import ec.com.gesso.model.company.CompanyModel;

/**
 * @author Gabriel
 *
 */
public class CompanyModelSerializer implements JsonSerializer<CompanyModel> {

	@Override
	public JsonElement serialize(CompanyModel companyModel, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject jsonCompanyModel = new JsonObject();
        jsonCompanyModel.addProperty("id", companyModel.getId());
        jsonCompanyModel.addProperty("razonSocial", companyModel.getRazonSocial());
        jsonCompanyModel.addProperty("ruc", companyModel.getRuc());
        jsonCompanyModel.addProperty("nombreComercial", companyModel.getNombreComercial());
        jsonCompanyModel.addProperty("typesCompanies", companyModel.getTypesCompanies());
        jsonCompanyModel.addProperty("typeProductiveSector", companyModel.getTypeProductiveSector());
        jsonCompanyModel.addProperty("idGeopoliticalDivisionCountry", companyModel.getIdGeopoliticalDivisionCountry());
        jsonCompanyModel.addProperty("idGeopoliticalDivisionProvince", companyModel.getIdGeopoliticalDivisionProvince());
        jsonCompanyModel.addProperty("idGeopoliticalDivisionCity", companyModel.getIdGeopoliticalDivisionCity());
        
        JsonArray jsonIntList=new JsonArray();
        
        for (String idSchedulesWork : companyModel.getSchedulesWork()) {
        	jsonIntList.add(new JsonPrimitive(idSchedulesWork));
		}
        
        jsonCompanyModel.add("schedulesWork", jsonIntList);
        
        
        JsonObject jsonActivityEconomicModelPrincipal = new JsonObject();
        jsonActivityEconomicModelPrincipal.addProperty("id", companyModel.getActividadComercialPrincipal().getId());
        jsonActivityEconomicModelPrincipal.addProperty("name", companyModel.getActividadComercialPrincipal().getName());
        jsonCompanyModel.add("actividadComercialPrincipal", jsonActivityEconomicModelPrincipal);
        
        JsonObject jsonActivityEconomicModelSecundaria = new JsonObject();
        jsonActivityEconomicModelSecundaria.addProperty("id", companyModel.getActividadComercialPrincipal().getId());
        jsonActivityEconomicModelSecundaria.addProperty("name", companyModel.getActividadComercialPrincipal().getName());
        jsonCompanyModel.add("actividadComercialSecuandaria", jsonActivityEconomicModelSecundaria);
        
        JsonObject jsonEmail = new JsonObject();
        jsonEmail.addProperty("id", companyModel.getEmail().getId());
        jsonEmail.addProperty("emailaddess", companyModel.getEmail().getEmailaddess());
        jsonCompanyModel.add("email", jsonEmail);
        
        JsonObject jsonTelefono = new JsonObject();
        jsonTelefono.addProperty("id", companyModel.getTelefono().getId());
        jsonTelefono.addProperty("number", companyModel.getTelefono().getNumber());
        jsonCompanyModel.add("telefono", jsonTelefono);
        
        JsonObject jsonCelular= new JsonObject();
        jsonCelular.addProperty("id", companyModel.getCelular().getId());
        jsonCelular.addProperty("number", companyModel.getCelular().getNumber());
        jsonCompanyModel.add("celular", jsonCelular);
        
        JsonObject jsonDireccion= new JsonObject();
        jsonDireccion.addProperty("id", companyModel.getDireccion().getId());
        jsonDireccion.addProperty("nameAddress", companyModel.getDireccion().getNameAddress());
        jsonCompanyModel.add("direccion", jsonDireccion);
        
        return jsonCompanyModel; 
	}

}
