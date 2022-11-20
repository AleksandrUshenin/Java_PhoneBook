package ContactBook.Interfaces;

public interface IContact {
    int getId();
    String getName();
    String getPatronymic();
    String getSurname();
    String getNumber();
    void edit(String name, String patronymoc, String surname, String number);
}
