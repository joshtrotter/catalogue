/**
 * 
 */
package trotterj.catalogue.api.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author jtrotter
 *
 */
public class Catalogue<E extends CatalogueItem> implements Serializable {
	
	private static final long serialVersionUID = -4611884584607995778L;
	
	private String name;
	private List<E> items;
	private String parametricType;
	
	@SuppressWarnings("unused")
	private Catalogue() {}
			
	public Catalogue(String name, Class<E> itemType) {
		this.name = name;
		this.parametricType = itemType.getName();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<E> getItems() {
		return items;
	}
	public void setItems(List<E> items) {
		this.items = items;
	}
	public String getParametricType() {
		return parametricType;
	}
	public void setParametricType(String parametricType) {
		this.parametricType = parametricType;
	}
	
		
}
