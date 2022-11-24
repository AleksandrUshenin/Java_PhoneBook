package Implement;

import Interfaces.IContact;

import java.io.Serializable;

public final class Contact implements IContact, Serializable {
    private int id;
    private String name;
    private String patronymic;
    private String surname;
    private String number;
    
    public Contact(int id, String name, String patronymic, String surname, String number) {
        this.id = id;
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.number = number;
    }

    @Override
    public int getId() {
        return id;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getPatronymic() {
        return patronymic;
    }
    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public void edit(String name, String patronymoc, String surname, String number) {
        this.name = name;
        this.patronymic = patronymoc;
        this.surname = surname;
        this.number = name;
    }

    @Override
    public String toString() {
        var s = "id:" + id + " Name:" + name + " patronymic:"+ patronymic + " surname:" + surname +" number:" + number;
        return s;
    }
}
