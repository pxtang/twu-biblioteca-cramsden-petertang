/**
 * Created by ptang on 8/4/15.
 */
public class Book {
    private String title;
    private String author;
    private Integer year;


    public Book(String title, String author, Integer year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String toString() {
        return String.format("%s | %s | %d", title, author, year);
    }
}
