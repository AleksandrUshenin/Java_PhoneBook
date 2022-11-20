package ContactBook.Implement;

import ContactBook.Interfaces.IContact;
import ContactBook.Interfaces.IHandler;

import java.beans.XMLDecoder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class HandlerJson implements IHandler {
    @Override
    public void importer() {
        InputStream inputStream = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };
        XMLDecoder xmlDecoder = new XMLDecoder(inputStream);
    }

    @Override
    public void exporter(List<IContact> contactList) {
    }
}
