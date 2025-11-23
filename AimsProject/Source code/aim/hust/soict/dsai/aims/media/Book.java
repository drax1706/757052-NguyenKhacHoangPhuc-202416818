package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Book extends Media {

    private ArrayList<String> authors = new ArrayList<>();

    ////

    public Book() {
        super();
    }

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category) {
        super(title, category);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Book(String title, String category, float cost, ArrayList<String> authors) {
        super(title, category, cost);
        if (authors != null) {
            this.authors = authors;
        }
    }

    ///////

    
    public void addAuthor(String authorName) {
        if (authorName == null) return;
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if (authorName == null) return;
        if (!authors.contains(authorName)) {
            System.out.println("khong co de remove");
        } else {
            authors.remove(authorName);
        }
    }
    @Override
    public String toString() {
        return "BOOK - " + getTitle()
                + " - " + getCategory()
                + " - Authors: " + authors
                + " - " + getCost() + " $";
    }

}
