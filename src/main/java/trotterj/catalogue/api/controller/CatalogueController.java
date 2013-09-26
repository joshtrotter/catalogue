/**
 * 
 */
package trotterj.catalogue.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import trotterj.catalogue.api.domain.Catalogue;
import trotterj.catalogue.api.service.CatalogueService;

/**
 * @author jtrotter
 *
 */
@Controller
@RequestMapping("/v1/catalogue")
public class CatalogueController {
	
	@Autowired CatalogueService service;
	
	@RequestMapping(value="/{catalogueType}", method = RequestMethod.GET)
	public @ResponseBody Catalogue<?> getRandomCatalogue(@PathVariable String catalogueType) {
		if ("movies".equals(catalogueType)) {
			return service.getMyMovies(); 
		} else {
			return service.getMyBooks();
		}
	}
	
	@RequestMapping(value="/{catalogueType}", method = RequestMethod.PUT)
	public @ResponseBody void updateCatalogue(@RequestBody Catalogue<?> catalogue, @PathVariable String catalogueType) {
		if ("movies".equals(catalogueType)) {
			service.setMyMovies(catalogue);
		} else {
			service.setMyBooks(catalogue);
		}
	}

}
