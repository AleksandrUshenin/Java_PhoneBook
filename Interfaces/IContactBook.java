package Interfaces;

import java.util.List;

public interface IContactBook {
    void currentMaxId();
    void addContact(String name, String patronymoc, String surname, String number);
    void importContact(int id, String name, String patronymoc, String surname, String number);
    void importContactList(List<IContact> contactList);
    IContact getById(int id);
    IContact getBySurname(String surname);
    void editConatct(int id, String name, String patronymoc, String surname, String number);
    boolean deleteContact(int id);
    List<IContact> getSorted();
    List<IContact> getUnsorted();
}
