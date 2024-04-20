package person;
import library.Library;
import libraryItem.Book;
import libraryItem.Journal;
import libraryItem.Magazine;
public class Librarian {
	private Student[] issuedTo;
	private int issuedBooks;
	private int issuedMagazines;
	private int issuedJournals;
	private int numStudents; // no of students whom book is issued
	private final int FINE_CONST = 10;
	
	public Librarian() {
		issuedTo = new Student[300];
	}
	public boolean issueBook(Student student, String title, String category) {
		boolean result = false;
		Book b_f = null;
		Book []arr = Library.getBook();
			
		for(Book b : arr) {
			if(b.getTitle().equals(title) && b.getQuantity() > 0) {
				b_f = b;
				b.decreaseQuantity();
				issuedBooks++;
				issuedTo[numStudents] = student;
				numStudents++;
			}
		}
		if(student instanceof BE && b_f != null) {
			BE s = (BE)student;
			result = s.addBook(b_f);
		}
		if(student instanceof ME && b_f != null) {
			ME s = (ME)student;
			result = s.addBook(b_f);
		}
		if(student instanceof PhD && b_f != null) {
			PhD s = (PhD)student;
			result = s.addBook(b_f);
		}
		//search in library in category array
		//decrease count
		//add book in student's category array
		//add student in issuedTo array
		//use instanceof to check max limit and max duration, allocate accordingly
		//set book's due date and issue date
		return result;
	}
	
	public boolean issueMag(Student student, String title, String category) {
		boolean result = false;
		Magazine m_f = null;
		Magazine []arr = Library.getMagazine();
			
		for(Magazine m : arr) {
			if(m.getTitle().equals(title) && m.getQuantity() > 0) {
				m_f = m;
				issuedMagazines++;
				m.decreaseQuantity();
				issuedTo[numStudents] = student;
				numStudents++;
			}
		}

		if(student instanceof BE && m_f != null) {
			BE s = (BE)student;
			result = s.addMag(m_f);
		}
		if(student instanceof ME && m_f != null) {
			ME s = (ME)student;
			result = s.addMag(m_f);
		}
		if(student instanceof PhD && m_f != null) {
			PhD s = (PhD)student;
			result = s.addMag(m_f);
		}
		return result;
	}
	
	public boolean issueJourno(Student student, String title, String category) {
		boolean result = false;
		Journal j_f = null;
		Journal []arr = Library.getJournal();
			
		for(Journal j : arr) {
			if(j.getTitle().equals(title)) {
				j_f = j;
				issuedJournals++;
				j.decreaseQuantity();
				issuedTo[numStudents] = student;
				numStudents++;
			}
		}

		if(student instanceof BE && j_f != null ) {
			BE s = (BE)student;
			result = s.addJourno(j_f);
		}
		if(student instanceof ME && j_f != null) {
			ME s = (ME)student;
			result = s.addJourno(j_f);
		}
		if(student instanceof PhD && j_f != null) {
			PhD s = (PhD)student;
			result = s.addJourno(j_f);
		}
		
		return result;
	}
	
	public int acceptBook(Student student, String title, String category, int returnDays) {
		Book b_f = null;
		int fine = 0;
		Book []arr = Library.getBook();
		for(Book b : arr) {
			if(b.getTitle().equals(title)) {
				b_f = b;
				b.increaseQuantity();
				issuedTo[numStudents] = null;
				numStudents--;
			}
		}
		if(student instanceof BE) {
			BE s = (BE)student;
			s.remBook(b_f);
			if(returnDays>s.MAX_DURATION_DAYS) {
				fine = (returnDays - s.MAX_DURATION_DAYS)*FINE_CONST;
			}
		}
		if(student instanceof ME) {
			ME s = (ME)student;
			s.remBook(b_f);
			if(returnDays>s.MAX_DURATION_DAYS) {
				fine = (returnDays - s.MAX_DURATION_DAYS)*FINE_CONST;
			}
		}
		if(student instanceof PhD) {
			PhD s = (PhD)student;
			s.remBook(b_f);
			if(returnDays>s.MAX_DURATION_DAYS) {
				fine = (returnDays - s.MAX_DURATION_DAYS)*FINE_CONST;
			}
		}
		
		//remove book from student's category array
		//add to library's category array
		//decrease count for student
		//increase count for library
		//check for fine
		return fine;
	}
	
	public int acceptMag(Student student, String title, String category, int returnDays) {
		Magazine m_f = null;
		int fine = 0;
		Magazine []arr = Library.getMagazine();
		for(Magazine m : arr) {
			if(m.getTitle().equals(title)) {
				m_f = m;
				m.increaseQuantity();
				issuedTo[numStudents] = null;
				numStudents--;
			}
		}
		if(student instanceof BE) {
			BE s = (BE)student;
			s.remMag(m_f);
			if(returnDays>s.MAX_DURATION_DAYS) {
				fine = (returnDays - s.MAX_DURATION_DAYS)*FINE_CONST;
			}
		}
		if(student instanceof ME) {
			ME s = (ME)student;
			s.remMag(m_f);
			if(returnDays>s.MAX_DURATION_DAYS) {
				fine = (returnDays - s.MAX_DURATION_DAYS)*FINE_CONST;
			}
		}
		if(student instanceof PhD) {
			PhD s = (PhD)student;
			s.remMag(m_f);
			if(returnDays>s.MAX_DURATION_DAYS) {
				fine = (returnDays - s.MAX_DURATION_DAYS)*FINE_CONST;
			}
		}
		return fine;
	}
	
	public int acceptJourno(Student student, String title, String category, int returnDays) {
		Journal j_f = null;
		int fine = 0;
		Journal []arr = Library.getJournal();
		for(Journal j : arr) {
			if(j.getTitle().equals(title)) {
				j_f = j;
				j.increaseQuantity();
				issuedTo[numStudents] = null;
				numStudents--;
			}
		}
		if(student instanceof BE) {
			BE s = (BE)student;
			s.remJourno(j_f);
			if(returnDays>s.MAX_DURATION_DAYS) {
				fine = (returnDays - s.MAX_DURATION_DAYS)*FINE_CONST;
			}
		}
		if(student instanceof ME) {
			ME s = (ME)student;
			s.remJourno(j_f);
			if(returnDays>s.MAX_DURATION_DAYS) {
				fine = (returnDays - s.MAX_DURATION_DAYS)*FINE_CONST;
			}
		}
		if(student instanceof PhD) {
			PhD s = (PhD)student;
			s.remJourno(j_f);
			if(returnDays>s.MAX_DURATION_DAYS) {
				fine = (returnDays - s.MAX_DURATION_DAYS)*FINE_CONST;
			}
		}
		return fine;
	}
	
	
}
