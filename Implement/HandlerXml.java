package ContactBook.Implement;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import ContactBook.Interfaces.IContact;
import ContactBook.Interfaces.IHandler;

public class HandlerXml implements IHandler {

    private ContactBook contactBook;

    public HandlerXml(ContactBook contactBook) {
        this.contactBook = contactBook;
    }

    @Override
    public void importer() {
        String fileName = "PhoneBook.xml";
        try
        {
            XMLStreamReader xmlr = XMLInputFactory.newInstance().createXMLStreamReader(fileName, new FileInputStream(fileName));
            List<String> stringList = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            while (xmlr.hasNext())
            {
                xmlr.next();
                if (xmlr.isStartElement())
                {
                    sb.delete(0, sb.length());
                    sb.append(xmlr.getLocalName() + ":");
                }
                else if(xmlr.isEndElement())
                {
                    if (sb.length() > 0)
                    {
                        stringList.add(sb.toString());
                        sb.delete(0, sb.length());
                    }
                }
                else if (xmlr.hasText() && xmlr.getText().trim().length() > 0)
                {
                    sb.append(xmlr.getText());
                }
            }
            parse(stringList);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    private void parse(List<String> list)
    {
        List<IContact> contactList = new ArrayList<>();
        int id = 0;
        String name = null, patronymic = null, surname = null, number = null;
        for (var s : list) {
            String[] res = s.split(":");
            switch (res[0])
            {
                case "id":
                    id = Integer.parseInt(res[1]);
                    break;
                case "name":
                    name = res[1];
                    break;
                case "patronymic":
                    patronymic = res[1];
                    break;
                case "surname":
                    surname = res[1];
                    break;
                case "number":
                    number = res[1];
                    contactList.add(new Contact(id, name, patronymic, surname, number ));
                    break;
            }
            //contactList.add(new Contact(id, name, patronymic, surname, number ));
            //contactBook.addContact(name, patronymic, surname, number);
        }
        //contactList.add(new Contact(id, name, patronymic, surname, number ));
        contactBook.importContactList(contactList);
    }

    static void OOO()
    {
        String fileName = "PhoneBook.xml";
        try
        {
            XMLStreamReader xmlr = XMLInputFactory.newInstance().createXMLStreamReader(fileName, new FileInputStream(fileName));
            while (xmlr.hasNext())
            {
                xmlr.next();
                if (xmlr.isStartElement())
                {
                    System.out.println(xmlr.getLocalName() + " 1");
                }
                else if(xmlr.isEndElement())
                {
                    System.out.println(xmlr.getLocalName()+ " 2");
                }
                else if (xmlr.hasText() && xmlr.getText().trim().length() > 0)
                {
                    System.out.println(xmlr.getText() + " 3");
                }
            }
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    static void EEE()
    {
        try {
            String fileName = "PhoneBook.xml";
            XMLOutputFactory output = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = output.createXMLStreamWriter(new FileWriter(fileName));

            writer.writeStartDocument("1.0");
            writer.writeStartElement("BookCatalogue");
            for (int i = 0; i < 5; i++) {
                writer.writeStartElement("Book");

                writer.writeStartElement("Titel");
                writer.writeCharacters("Book # " + i);
                writer.writeEndElement();

                writer.writeStartElement("Author");
                writer.writeCharacters("Author # " + i);
                writer.writeEndElement();

                writer.writeStartElement("Date");
                writer.writeCharacters(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                writer.writeEndElement();

                writer.writeStartElement("Cost");
                writer.writeAttribute("currency", "USD");
                writer.writeCharacters("Book # " + i);
                writer.writeEndElement();

                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush();
        }
        catch (Exception ex)
        {}
    }
    @Override
    public void exporter(List<IContact> contactList)
    {
        try {
            String fileName = "PhoneBook.xml";
            XMLOutputFactory output = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = output.createXMLStreamWriter(new FileWriter(fileName));

            writer.writeStartDocument("1.0");
            writer.writeStartElement("PhoneBookCatalogue");
            int numUser = 0;
            for (var user : contactList) {
                writer.writeStartElement("user-" + numUser++);
                writer.writeStartElement("id");
                writer.writeCharacters("" + user.getId());
                writer.writeEndElement();
                writer.writeStartElement("name");
                writer.writeCharacters(user.getName());
                writer.writeEndElement();
                writer.writeStartElement("patronymic");
                writer.writeCharacters(user.getPatronymic());
                writer.writeEndElement();
                writer.writeStartElement("surname");
                writer.writeCharacters(user.getSurname());
                writer.writeEndElement();
                writer.writeStartElement("number");
                writer.writeCharacters(user.getNumber());
                writer.writeEndElement();
                writer.writeEndElement();
            }

            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush();
        }
        catch (Exception ex)
        {}
    }
}
