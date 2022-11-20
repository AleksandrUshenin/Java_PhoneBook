package ContactBook.Interfaces;

import java.util.List;

public interface IHandler {
    void importer();
    void exporter(List<IContact> contactList);
}
