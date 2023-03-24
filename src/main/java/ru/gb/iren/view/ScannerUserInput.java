package ru.gb.iren.view;

import java.util.Scanner;

/**
 * Класс для считывания данных из консоли пользователя
 */
public class ScannerUserInput {
    private final Scanner scanner;

    public ScannerUserInput() {
        this.scanner = new Scanner(System.in);
    }

    public String parseUserInput(){
        return scanner.nextLine();

    }
}
