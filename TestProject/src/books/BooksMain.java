package books;

import java.util.ArrayList;

public class BooksMain {
    public static void main(String[] args) {
        Library lib = new Library();

        ArrayList<String> b1a = new ArrayList<>();
        b1a.add("Joshua Bloch");
        ArrayList<String> b2a = new ArrayList<>();
        b2a.add("Robert Martin");
        ArrayList<String> b3a = new ArrayList<>();
        b3a.add("J.R.R. Tolkien");
        ArrayList<String> b4a = new ArrayList<>();
        b4a.add("J.R.R. Tolkien");
        ArrayList<String> b5a = new ArrayList<>();
        b5a.add("Robert Martin");

        Book b1 = new Book("Effective Java", "Programming", b1a);
        Book b2 = new Book("Clean Code", "Programming", b2a);
        Book b3 = new Book("The Hobbit", "Fantasy", b3a);
        Book b4 = new Book("The Lord of the Rings", "Fantasy", b4a);
        Book b5 = new Book("Clean Architecture", "Programming", b5a);

        lib.addBook(b1);
        lib.addBook(b2);
        lib.addBook(b3);
        lib.addBook(b4);
        lib.addBook(b5);

        lib.listGenres(); 
        lib.listAuthors(); 
        lib.listAllBooks();
        lib.listBooksByTitle();
        lib.listBooksByGenre("Programming");

    }
}
