import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by cramsden on 8/5/15.
 */
public class ConsoleTest {
    Library library;
    PrintStream output;
    Console console;
    Book book;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        when(library.open()).thenReturn("Welcome to the Library! Biblioteca is available!");
        List<Book> books = new ArrayList<>();
        book = mock(Book.class);
        books.add(book);
        when(library.listAllBooks()).thenReturn(books);
        output = mock(PrintStream.class);
        console = new Console(library,output);

    }

    @Test
    public void shouldPrintWelcomeWhenLibraryOpens() {

        console.openLibrary();
        verify(output).println(library.open());

    }

    @Test
    public void shouldListBooksWhenLibraryListsBooks() {
        console.listAllBooks();
        verify(output).println(book);
    }

    @Test
    public void shouldGenerateMenu() throws Exception {
        console.generateMenu();
        verify(output).println("List Books");

    }
}
