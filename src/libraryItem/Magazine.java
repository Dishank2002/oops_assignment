package libraryItem;

public class Magazine implements LibraryItem{
	private String title;
	private String author;
	private int UniqueId;
	private int quantity;
	
	public Magazine(String title,String author,int UniqueId,int quantity)
	{
		this.author = author;
		this.title = title;
		this.UniqueId = UniqueId;
		this.quantity = quantity;
		
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
