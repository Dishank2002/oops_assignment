package person;
import libraryItem.Book;
import libraryItem.Journal;
import libraryItem.Magazine;

public class ME extends Student{
	public final static String degree = "Masters";
	public final static int MAX_DURATION_DAYS = 42;
	public final static int MAX_LIMIT = 6;
	
	public ME(String name, String ID, String degree) {
		super(name, ID, degree);
	}
	
	int numBooks = 0;
	int numMags = 0;
	int numJourns = 0;
	
	private Book[] issuedBooks = new Book[MAX_LIMIT];
	private Journal[] issuedJournals = new Journal[MAX_LIMIT];
	private Magazine[] issuedMagazines = new Magazine[MAX_LIMIT];
	
	public boolean addBook(Book b) {
		if(numBooks < MAX_LIMIT) issuedBooks[numBooks++] = b;
		else {
			return false;
		}
		if(numBooks + numMags + numJourns > MAX_LIMIT) {
			numBooks--;
			issuedBooks[numBooks] = null;
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean addMag(Magazine m) {
		if(numMags < MAX_LIMIT) issuedMagazines[numMags++] = m;
		else {
			return false;
		}
		if(numBooks + numMags + numJourns > MAX_LIMIT) {
			numMags--;
			issuedMagazines[numMags] = null;
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean addJourno(Journal j) {
		if(numJourns < MAX_LIMIT) issuedJournals[numJourns++] = j;
		else {
			return false;
		}
		if(numBooks + numMags + numJourns > MAX_LIMIT) {
			numJourns--;
			issuedJournals[numJourns] = null;
			return false;
		}
		else {
			return true;
		}
	}
	
	public void remBook(Book b) {
		int index = 0;
		for(int i = 0; i<issuedBooks.length; i++) {
			if(issuedBooks[i].getTitle().equals(b.getTitle())) {
				index = i;
				break;
			}
		}
		while(index<issuedBooks.length) {
			issuedBooks[index] = issuedBooks[index+1];
			index++;
		}
		issuedBooks[index] = null;
	}
	
	public void remMag(Magazine m) {
		int index = 0;
		for(int i = 0; i<issuedMagazines.length; i++) {
			if(issuedBooks[i].getTitle().equals(m.getTitle())) {
				index = i;
				break;
			}
		}
		while(index<issuedMagazines.length) {
			issuedMagazines[index] = issuedMagazines[index+1];
			index++;
		}
		issuedMagazines[index] = null;
	}
	
	public void remJourno(Journal j) {
		int index = 0;
		for(int i = 0; i<issuedJournals.length; i++) {
			if(issuedJournals[i].getTitle().equals(j.getTitle())) {
				index = i;
				break;
			}
		}
		while(index<issuedJournals.length) {
			issuedJournals[index] = issuedJournals[index+1];
			index++;
		}
		issuedJournals[index] = null;
	}
}
