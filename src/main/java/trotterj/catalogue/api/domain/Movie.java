/**
 * 
 */
package trotterj.catalogue.api.domain;


/**
 * @author jtrotter
 *
 */
public class Movie implements CatalogueItem {

	private static final long serialVersionUID = -7559081450478586745L;
	
	private String title;
	private String director;
	
	@SuppressWarnings("unused")
	private Movie() {}
	
	public Movie(String title, String director) {
		this.title = title;
		this.director = director;
	}
		
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

}
