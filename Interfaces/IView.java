package Interfaces;

import java.util.List;

public interface IView {
    void printMenu();
    void printMenuLoadSave(int index);
    void printListBook(List<IContact> contactList);
    void printBook(IContact contact);
    void printInDisplay(String message);
    String readLine(String message);
    String readLine();
}
