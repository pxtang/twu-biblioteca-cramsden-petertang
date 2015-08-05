import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by cramsden on 8/5/15.
 */
public class ConsoleTest {
    private Library library;
    private PrintStream output;
    private Console console;
    private Book book;
    private HashMap<String, Command> menuItems;
    private BufferedReader input;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        when(library.open()).thenReturn("Welcome to the Library! Biblioteca is available!");
        List<Book> books = new ArrayList<>();
        book = mock(Book.class);
        books.add(book);
        when(library.listAllBooks()).thenReturn(books);
        output = mock(PrintStream.class);
        menuItems = new HashMap<>();
        input = mock(BufferedReader.class);
        console = new Console(library,output,menuItems,input);

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
        String itemNum = "1";
        Command listBooksCommand = mock(ListBooksCommand.class);
        when(listBooksCommand.description()).thenReturn("List Books");
        menuItems.put(itemNum, listBooksCommand);

        console.generateMenu();
        verify(output).printf("%s: %s\n",itemNum,listBooksCommand.description());

    }

    @Test
    public void shouldGet1WhenUserInputs1() throws IOException {
        when(input.readLine()).thenReturn("1");
        String choice = console.getChoice();

        assertThat(choice, is("1"));
    }

    @Test
    public void shouldGet2WhenUserInputs2() throws IOException {
        when(input.readLine()).thenReturn("2");

        String choice = console.getChoice();

        assertThat(choice, is("2"));
    }

    @Test
    public void shouldExecuteOptionOneIfUserInputs1() throws Exception {
        String choice = "1";

        ListBooksCommand listBooksCommand = mock(ListBooksCommand.class);
        menuItems.put("1", listBooksCommand);

        console.executeChoice(choice);

        verify(listBooksCommand).execute();
    }

    @Test
    public void shouldSayInvalidOptionIfUserInputInvalidOption() throws Exception {
        console.executeChoice("Thoughtworks, go!");
        verify(output).println("Select a valid option!");
    }

    @Test
    public void shouldExecuteQuitWhenEntersQ() throws Exception {
        String choice = "q";

        QuitCommand quitCommand = mock(QuitCommand.class);
        menuItems.put("q", quitCommand);
        console.executeChoice(choice);

        verify(quitCommand).execute();
    }
}
