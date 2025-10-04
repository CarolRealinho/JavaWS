package books;

import java.util.ArrayList;

public class Book {
    private String title;
    private String genre;
    private ArrayList<String> authors;

    public Book(String title, String genre, ArrayList<String> authors){
        this.title = title;
        this.genre = genre;
        this.authors = authors;
    }

    public String getTitle(){
        return this.title;
    }

    public String getGenre(){
        return this.genre;
    }

    public ArrayList<String> getAuthors(){
        return this.authors;
    }

    public String toString(){
        return "(" + title + ", " + genre + ", " + authors + ")";
    }
    
}