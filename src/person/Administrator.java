package person;
import Library.library;
public class Administrator {
	
    public static void addBook(Book book){
        library.addBook(book);
    }

    public static void addMagazine(Magazine magazine){
        library.addMagazine(magazine);
    }
    public static void addJournal(Journal journal){
        library.addJournal(journal);
    }

    public static Integer get_no_Issuedbook(){
        return library.issuedBooks;
    }
    public static Integer get_no_Issuedmagazine(){
        return library.issuedMagazines;
    }
    public static Integer get_no_Issuedjournal(){
        return library.issuedJournals;
    }
}
