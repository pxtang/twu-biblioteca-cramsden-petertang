/**
 * Created by ptang on 8/4/15.
 */

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class BookTest {
    private Book book;
    private String author;
    private String title;
    private Integer year;

    @Before
    public void setUp(){
        title = "Harry Potter and the Sorcerer's Stone";
        author = "JK Rowling";
        year = 1997;

        book = new Book(title,author,year);
    }

    @Test
    public void shouldGiveBookInfoInColumnsWhenConvertedToString() {
        String bookString = book.toString();
        assertThat(bookString, is("Harry Potter and the Sorcerer's Stone | JK Rowling | 1997"));
    }


}
