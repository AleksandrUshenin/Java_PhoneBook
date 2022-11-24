package Implement;

import Interfaces.IContact;
import Interfaces.IContactBook;
import Interfaces.IController;
import Interfaces.IHandler;
import Interfaces.IView;

import java.util.List;

public class Controller implements IController {
    private IHandler handlerXml;
    private IView view;
    private IContactBook contactBook;
    //
    //
    //

    public Controller(IView view, IContactBook contactBook, IHandler handlerXml) {
        this.view = view;
        this.contactBook = contactBook;
        this.handlerXml = handlerXml;

        startLoad();
    }

    @Override
    public void startDisplayPrint()
    {
        view.printMenu();
    }
    @Override
    public String getCommandForMenu()
    {
        return view.readLine();
    }

    @Override
    public void loadData()
    {
        view.printMenuLoadSave(1);
        var res = view.readLine();
        if (res.equals("1"))
        {
        }
        else if (res.equals("2"))
        {
            handlerXml.importer();
        }
        
        doLogger(1, "Загрузка контактов при запуске приложения");
    }

    @Override
    public void saveData(List<IContact> bookList) {
        view.printMenuLoadSave(2);
        var res = view.readLine();
        if (res.equals("1"))
        {
        }
        else if (res.equals("2"))
        {
            handlerXml.exporter(bookList);
        }
        doLogger(1, "Сохранено через %s способ " + res); //.formatted(res)
    }

    @Override
    public void startLoad() {
        handlerXml.importer();
    }

    @Override
    public void search(int indexTypeSearch) {
        try {
            IContact result;
            if (indexTypeSearch == 1)
            {
                int id = Integer.parseInt(view.readLine("Введите id: "));
                result = contactBook.getById(id);
                searchCorrectly(result);
                view.printBook(result);
            }
            else
            {
                String surname = view.readLine("Введите фамилию: ");
                result = contactBook.getBySurname(surname);
                searchCorrectly(result);
                view.printBook(result);
            }
        }
        catch (Exception ex)
        {
            doLogger(3, "Ошибка поиска типом: " + indexTypeSearch);//.formatted(indexTypeSearch));
        }
    }

    @Override
    public void searchCorrectly(IContact contact) {
        if (contact == null)
        {
            view.printInDisplay("Контакт не найден!");
            doLogger(1, "Контакт не найден! " + contact.toString()); //.formatted(contact.toString())
        }
    }

    @Override
    public void printBook() {
        var book = contactBook.getSorted();
        view.printListBook(book);
    }

    @Override
    public void addUser() {
        String name = view.readLine("Введите имя: ");
        String patronimic = view.readLine("Введите отчество: ");
        String surname = view.readLine("Введите фамилию: ");
        String number = view.readLine("Введите номер: ");
        contactBook.addContact(name, patronimic, surname, number);

        doLogger(1, "Добавлен контакт: %s %s %s %s".format(name, patronimic, surname, number));//.formatted(name, patronimic, surname, number));
    }

    @Override
    public void delete() {
        int id = Integer.parseInt(view.readLine("Введите id для удаления: "));
        boolean res = contactBook.deleteContact(id);
        if (res)
        {
            doLogger(1, "Удален контакт id: " + id); //.formatted(id)
        }
        else
        {
            doLogger(1, "Ошибка при удалении контакт по id: " + id);//.formatted(id));
        }
    }

    @Override
    public void doLogger(int index, String message) {
        LoggerClass loggerClass = new LoggerClass();
        loggerClass.log(message);

        if (index == 1)
        {}
        else if (index == 2) {
        }
        else
        {}
    }
}
