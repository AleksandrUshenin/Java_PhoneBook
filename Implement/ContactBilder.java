package Implement;

import Interfaces.IContact;

public final class ContactBilder {
    public static IContact newContact(int id, String name, String patronymoc, String surname, String number)
    {
        return new Contact(id, name, patronymoc, surname, number);
    }
}
