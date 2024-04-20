package person;
public class Student{
	protected String degree;
	private String name;
	private String ID;
	public int fine;
	
	protected int MAX_DURATION_DAYS;
	protected int MAX_LIMIT;
	
	
	public Student(String name, String ID, String degree) {
		this.name = name;
		this.ID = ID;
		this.degree = degree;
	}
	
	
	public String getDueDate(String issueDate, int max_duration_days) {
		return "";
	}
	
}
