//package ContactBook;

import Implement.ConsoleUserInterface;
import Implement.ContactBook;
import Implement.Controller;
import Implement.HandlerXml;
import Implement.View;
import Interfaces.IContact;
import Interfaces.IContactBook;
import Interfaces.IController;
import Interfaces.IHandler;
import Interfaces.IView;
import Interfaces.UserInterface;

public final class Start {
    public static void main(String[] args) {
        UserInterface userInterface = new ConsoleUserInterface();
        IView view = new View(userInterface);
        IContactBook contactBook = new ContactBook();
        IHandler handler = new HandlerXml(contactBook);
        IController controller = new Controller(view, contactBook, handler);

        Model model = new Model(controller, contactBook);
        model.run();
    }
}
