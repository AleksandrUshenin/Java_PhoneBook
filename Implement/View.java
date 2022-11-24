package Implement;

import Interfaces.IContact;
import Interfaces.IView;
import Interfaces.UserInterface;

import java.util.List;

public class View implements IView {
    private UserInterface userInterface;

    public View(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public void printMenu() {
        userInterface.print("\n\t\tТелефонная кника");
        userInterface.print("=============================================");
        userInterface.print("\n\t" +
                "Команды:\n\t" + "1 - Добавить\n\t" +
                "2 - Вывести на экран список\n\t" +
                "3 - Удалить\n\t" + "4 - поиск по id\n\t" + "5 - Поиск по фамилии\n\t" +
                "6 - Загрузить\n\t" + "7 - Сохранить\n\t" + "0 - Выход");
    }

    @Override
    public void printMenuLoadSave(int index) {
        String message = index == 1 ? "Загрузить" : "Сохранить";

        userInterface.print("\n\t\tТелефонная кника");
        userInterface.print("=============================================");
        userInterface.print("\n\t 1 - " + message +" с помощью json \n\t 2 - " + message + " с помощью Xml");   //.formatted(message, message));
    }

    @Override
    public void printListBook(List<IContact> contactList) {
        userInterface.print("\n\t\tСписок контактов: \n");
        userInterface.print("=============================================");
        for (var user : contactList)
        {
            userInterface.print("\t" + user.toString());
        }
    }
    @Override
    public void printBook(IContact contact)
    {
        userInterface.print("\n\t\tСписок контактов: \n");
        userInterface.print("=============================================");
        userInterface.print("\t" + contact.toString());
    }


    @Override
    public void printInDisplay(String message) {
        userInterface.print(message);
    }

    @Override
    public String readLine(String message) {
        if (message == null)
            message = "Введите номер команды: ";
        userInterface.print(message);
        return userInterface.read();
    }
    
    @Override
    public String readLine() {
        return userInterface.read();
    }
}
