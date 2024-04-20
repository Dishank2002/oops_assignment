package libraryItem;

public class Book implements LibraryItem{
	private String title;
	private String author;
	private int UniqueId;
	private int edition;
	private int quantity;
	
	public Book(String title,String author,int UniqueId,int edition,int quantity)
	{
		this.author = author;
		this.title = title;
		this.edition = edition;
		this.quantity = quantity;
		this.UniqueId = UniqueId;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	public String getAuthor() {
		return this.author;
	}
	public int getUniqueId() {
		return this.UniqueId;
	}
	
	public void decreaseQuantity() {
		quantity--;
	}
	
	public void increaseQuantity() {
		quantity++;
	}

	public int getQuantity() {
		return this.quantity;
	}
}
