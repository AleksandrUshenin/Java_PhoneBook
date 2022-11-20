package ContactBook.Implement;

import ContactBook.Interfaces.UserInterface;

import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {
    private Scanner scanner;

    public ConsoleUserInterface() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }

    @Override
    public void clear() {
    }
}
