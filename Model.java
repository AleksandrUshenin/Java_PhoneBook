//package ContactBook;

import Interfaces.IContact;
import Interfaces.IContactBook;
import Interfaces.IController;
import Interfaces.IView;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private IView view;
    private IController controller;
    //private IContactBook contactBook;
    private IContactBook contactBook;
    private List<IContact> ListContactBook;

    public Model(IView view, IController controller, IContactBook contactBook/*,
                 List<IContact> listContactBook*/) {
        this.view = view;
        this.controller = controller;
        this.contactBook = contactBook;
        //ListContactBook = listContactBook;
        ListContactBook = new ArrayList<>();
    }

    public void run()
    {
        boolean runer = true;
        while (runer)
        {
            view.printMenu();
            runer = doCommand(view.readLine(null));
        }
    }

    private boolean doCommand(String idCommand)
    {
        switch (idCommand)
        {
            case "1":
                controller.addUser();
                break;
            case "2":
                controller.printBook();
                break;
            case "3":
                controller.delete();
                break;
            case "4":
                controller.search(1);
                break;
            case "5":
                controller.search(2);
                break;
            case "6":
                //ListContactBook =
                //        contactBook.importContactList(controller.loadData());
                controller.loadData();
                break;
            case "7":
                controller.saveData(contactBook.getUnsorted());
                break;
            default:
                return false;
        }
        return true;
    }
}
