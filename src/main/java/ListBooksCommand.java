/**
 * Created by pdale on 8/5/15.
 */
public class ListBooksCommand implements Command {
    private Console libraryConsole;

    public ListBooksCommand(Console libraryConsole) {

        this.libraryConsole = libraryConsole;
    }

    public void execute() {
       libraryConsole.listAllBooks();
    }

    @Override
    public String description() {
        return "List Books";
    }
}
