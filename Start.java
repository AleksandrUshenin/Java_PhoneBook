//package ContactBook;

import Implement.ConsoleUserInterface;
import Implement.ContactBook;
import Implement.Controller;
import Implement.View;
import Interfaces.IContact;
import Interfaces.IContactBook;
import Interfaces.IController;
import Interfaces.UserInterface;

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
