package libraryItem;


public class Journal implements LibraryItem{
	private String title;
	private String author;
	private int UniqueId;
	private int volume;
	private int quantity;
	
	public Journal(String title,String author,int UniqueId,int quantity,int volume)
	{
		this.author = author;
		this.title = title;
		this.UniqueId = UniqueId;
		this.quantity = quantity;
		this.volume = volume;
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

