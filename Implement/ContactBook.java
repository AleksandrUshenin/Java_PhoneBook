package Implement;

import Interfaces.IContact;
import Interfaces.IContactBook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactBook implements IContactBook {
    private static int id;
    private List<IContact> contactList;

    public ContactBook() {
        contactList = new ArrayList<>();
        id = 0;
    }

    @Override
    public void currentMaxId() {

    }

    @Override
    public void addContact(String name, String patronymoc, String surname, String number) {
        contactList.add(ContactBilder.newContact(id++, name, patronymoc, surname, number));
    }

    @Override
    public void importContact(int id, String name, String patronymoc, String surname, String number) {
        contactList.add(ContactBilder.newContact(id, name, patronymoc, surname, number));
    }

    @Override
    public void importContactList(List<IContact> contactList) {
        this.contactList = new ArrayList<>();
        for (IContact c : contactList)
        {
            id = c.getId();
            this.contactList.add(c);
        }
        ++id;
    }

    @Override
    public IContact getById(int id) {
        for (var con : contactList) {
            if (con.getId() == id)
                return con;
        }
        return null;
    }

    @Override
    public IContact getBySurname(String surname) {
        for (var con : contactList) {
            if(con.getSurname().equals(surname)) {//  == surname
                return con;
            }
        }
        return null;
    }

    @Override
    public void editConatct(int id, String name, String patronymoc, String surname, String number) {
        var sel = getById(id);
        sel.edit(name, patronymoc, surname, number);
    }

    @Override
    public boolean deleteContact(int id) {
        return contactList.remove(getById(id));
    }

    @Override
    public List<IContact> getSorted() {
        List<IContact> con = getUnsorted();
        con.sort(new Comparator<IContact>() {
            @Override
            public int compare(IContact o1, IContact o2) {
                if (o1.getId() > o2.getId())
                    return 1;
                else if (o1.getId() < o2.getId()) {
                    return -1;
                }
                return 0;
            }
        });
        return con;
    }

    @Override
    public List<IContact> getUnsorted() {
        return contactList;
    }
}
