package trotterj.catalogue.api.domain;

public class Book implements CatalogueItem {
	
	private static final long serialVersionUID = -2494908109124512019L;
	
	private String title;
	private String author;
	
	@SuppressWarnings("unused")
	private Book() {}
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
}
