package Implement;

import Interfaces.UserInterface;

import java.util.Scanner;

public final class ConsoleUserInterface implements UserInterface {
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
