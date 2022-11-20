package ContactBook;

import ContactBook.Implement.ConsoleUserInterface;
import ContactBook.Implement.ContactBook;
import ContactBook.Implement.Controller;
import ContactBook.Implement.View;
import ContactBook.Interfaces.IContact;
import ContactBook.Interfaces.IContactBook;
import ContactBook.Interfaces.IController;
import ContactBook.Interfaces.UserInterface;

public class Start {
    public static void main(String[] args) {
        UserInterface userInterface = new ConsoleUserInterface();
        View view = new View(userInterface);
        ContactBook contactBook = new ContactBook();
        IController controller = new Controller(view, contactBook);

        Model model = new Model(view, controller, contactBook);
        model.run();
    }
}
