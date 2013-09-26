/**
 * 
 */
package trotterj.catalogue.api.util;

import trotterj.catalogue.api.domain.Catalogue;

/**
 * @author jtrotter
 *
 */
public class CatalogueJacksonHttpMessageConverter extends BaseGenericJacksonHttpMessageConverter<Catalogue> {

	@Override
	public Class<Catalogue> getGenericType() {
		return Catalogue.class;
	}

}
