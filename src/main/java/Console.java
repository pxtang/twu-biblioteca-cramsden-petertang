import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cramsden on 8/5/15.
 */
public class Console {
    private Library library;
    private PrintStream printStream;
    private List<String> menuItems = new ArrayList<>();

    public Console(Library library, PrintStream printStream) {
        this.library = library;
        this.printStream = printStream;
        menuItems.add("List Books");
    }

    public void openLibrary(){
        printStream.println(library.open());
    }


    public void listAllBooks() {
        for (Book book : library.listAllBooks()) {
            printStream.println(book);
        }
    }

    public void runLibrary() {
        openLibrary();
        listAllBooks();
    }


    public void generateMenu() {
        for (String item : menuItems) {
            printStream.println(item);
        }
    }
}
