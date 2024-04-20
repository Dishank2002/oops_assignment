package library;
import libraryItem.Magazine;
import libraryItem.Journal;
import libraryItem.Book;

public class Library {
    private static Magazine[] allMags = new Magazine[100];
    private static Journal[] allJournals = new Journal[100];
    private static Book[] allBooks = new Book[100];
    int numBooks;
    int numMagazines;
    int numJournals;

    Library(Magazine[] allMags, Journal[] allJournals, Book[] allBooks) {
        for (Magazine m : allMags) {
            try {
                addMag(m);
            } catch (Exception e) {
                System.out.println("Error adding magazine: " + e.getMessage());
            }
        }
        for (Journal j : allJournals) {
            try {
                addJour(j);
            } catch (Exception e) {
                System.out.println("Error adding journal: " + e.getMessage());
            }
        }
        for (Book b : allBooks) {
            try {
                addBook(b);
            } catch (Exception e) {
                System.out.println("Error adding book: " + e.getMessage());
            }
        }
    }

    public void addBook(Book... book) throws Exception {
        if (numBooks < 100) {
            for (Book b : book) {
                if (searchItem("BOOK", b.getTitle()) >= 0) {
                    b.increaseQuantity();
                } else if (numBooks < 100) {
                    allBooks[numBooks] = b;
                    numBooks++;
                }
            }
        } else {
            throw new Exception("Book Limit Exceeded");
        }
    }

    public void addMag(Magazine... magazine) throws Exception {
        if (numMagazines < 100) {
            for (Magazine m : magazine) {
                if (searchItem("MAGAZINE", m.getTitle()) >= 0) {
                    m.increaseQuantity();
                } else if (numMagazines < 100) {
                    allMags[numMagazines] = m;
                    numMagazines++;
                }
            }
        } else {
            throw new Exception("Magazine Limit Exceeded");
        }
    }

    public void addJour(Journal... journal) throws Exception {
        if (numJournals < 100) {
            for (Journal j : journal) {
                if (searchItem("JOURNAL", j.getTitle()) >= 0) {
                    j.increaseQuantity();
                } else if (numJournals < 100) {
                    allJournals[numJournals] = j;
                    numJournals++;
                }
            }
        } else {
            throw new Exception("Journal Limit Exceeded");
        }
    }

    public int searchItem(String category, String title) {
        int i = 0;
        switch (category) {
            case "BOOK":
                for (Book b : allBooks) {
                    if (b != null && b.getTitle().equals(title)) {
                        return i;
                    }
                    i++;
                }
                break;
            case "JOURNAL":
                for (Journal j : allJournals) {
                    if (j != null && j.getTitle().equals(title)) {
                        return i;
                    }
                    i++;
                }
                break;
            case "MAGAZINE":
                for (Magazine m : allMags) {
                    if (m != null && m.getTitle().equals(title)) {
                        return i;
                    }
                    i++;
                }
                break;
        }
        return -1;
    }

    public static Book[] getBook() {
        return allBooks;
    }

    public static Journal[] getJournal() {
        return allJournals;
    }

    public static Magazine[] getMagazine() {
        return allMags;
    }
}
