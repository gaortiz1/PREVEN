package ec.com.gesso.test;

import java.util.Collection;

import org.junit.Test;

import ec.com.gesso.common.exception.GessoException;
import ec.com.gesso.model.entity.Catalog;
import ec.com.gesso.security.factory.GessoSecurityFactory;

public class CatalogTest {
	@Test
	public void buscarCatalogoSexo(){
		Collection<Catalog> lstCatalogs;
		try {
			lstCatalogs = GessoSecurityFactory.getInstance().getCatalogService().findSexCatalog();
			for(Catalog catalog: lstCatalogs){
				System.out.println(catalog);
			}
		} catch (GessoException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void buscarCatalogoVulnerabilidad(){
		Collection<Catalog> lstCatalogs;
		try {
			lstCatalogs = GessoSecurityFactory.getInstance().getCatalogService().findVulnerabilityCatalog();
			for(Catalog catalog: lstCatalogs){
				System.out.println(catalog);
			}
		} catch (GessoException e) {
			e.printStackTrace();
		}
	}
	
}
