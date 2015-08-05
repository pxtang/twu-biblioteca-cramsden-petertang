import java.io.*;
import java.util.*;

/**
 * Created by cramsden on 8/5/15.
 */
public class Console {
    private Library library;
    private PrintStream printStream;
    private Map<String, Command> menuItems;
    private BufferedReader bufferedReader;

    public Console(Library library, PrintStream printStream, Map<String, Command> menuItems, BufferedReader bufferedReader) {
        this.library = library;
        this.printStream = printStream;
        this.menuItems = menuItems;
        this.bufferedReader = bufferedReader;
        menuItems.put("1", new ListBooksCommand(this));
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
        generateMenu();
        String choice = getChoice();
        executeChoice(choice);
    }


    public void generateMenu() {
        Set<Map.Entry<String, Command>> items = menuItems.entrySet();
        for (Map.Entry<String, Command> item : items) {
            printStream.printf("%s: %s\n",item.getKey(),item.getValue().description());
        }
    }

    public String getChoice() {
        printStream.print("What choice would you like? ");
        String choice = null;
        try {
            choice = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return choice;
    }

    public void executeChoice(String choice) {
        if (menuItems.containsKey(choice)) {
            menuItems.get(choice).execute();
        }
        else {
            printStream.println("Select a valid option!");
        }
    }
}
