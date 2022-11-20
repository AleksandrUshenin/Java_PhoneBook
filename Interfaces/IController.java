package ContactBook.Interfaces;

import java.util.List;

public interface IController {
    List<IContact> loadData();
    void saveData(List<IContact> bookList);
    void startLoad();
    void search(int indexTypeSearch);
    void searchCorrectly(IContact contact);
    void printBook();
    void addUser();
    void delete();
    void doLogger(int index, String message);

}
