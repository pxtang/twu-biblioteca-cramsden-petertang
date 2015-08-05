import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by pdale on 8/5/15.
 */
public class ListBooksCommandTest {

    private Console libraryConsole;
    private ListBooksCommand listBooksCommand;

    @Before
    public void setUp() throws Exception {
        libraryConsole = mock(Console.class);
        listBooksCommand = new ListBooksCommand(libraryConsole);
    }

    @Test
    public void shouldCallListBooksWhenCommandExecutes() throws Exception {
        listBooksCommand.execute();

        verify(libraryConsole).listAllBooks();
    }

    @Test
    public void shouldReturnACommandDescriptionWhenRequested() throws Exception {
        assertThat(listBooksCommand.description(), is("List Books"));

    }
}
