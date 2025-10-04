package books;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeMap;
//import java.util.TreeSet;
import java.util.HashMap;

public class Library {
    private ArrayList<Book> books;
    private HashSet<String> genres;
    private LinkedHashSet<String> authors; // to order in alphabetical order: TreeSet; to order in insertion order: LinkedHashSet
    private TreeMap<String,Book> allBooks;
    private HashMap<String, ArrayList<Book>> genresBooks;

    public Library(){
        this.books = new ArrayList<Book>();
        this.genres = new HashSet<String>();
        this.authors = new LinkedHashSet<String>();
        this.allBooks = new TreeMap<String,Book>();
        this.genresBooks = new HashMap<String, ArrayList<Book>>();
    }

    public void addBook(Book book){
        this.books.add(book);
        this.genres.add(book.getGenre());
        for(String a:book.getAuthors()){
            this.authors.add(a);
        }
        this.allBooks.put(book.getTitle(), book);
        if(this.genresBooks.keySet().contains(book.getGenre())){
            this.genresBooks.get(book.getGenre()).add(book);
        }
        else{
            ArrayList<Book> newBook = new ArrayList<Book>();
            newBook.add(book);
            this.genresBooks.put(book.getGenre(), newBook);
        }
    }

    public void listAllBooks(){
        System.out.println(this.books);
    }

    public void listBooksByTitle(){
        for(Book t:this.allBooks.values()){
            System.out.println(t.toString());
        }
    }

    public void listGenres(){
        for(String g:genres){
            System.out.println(g);
        }
    }

    public void listAuthors(){
        for(String a:authors){
            System.out.println(a);
        }
    }

    public void listBooksByGenre(String genere){
        System.out.println(this.genresBooks.get(genere));
    }

}
