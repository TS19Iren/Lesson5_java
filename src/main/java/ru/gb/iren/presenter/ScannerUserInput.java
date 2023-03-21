package ru.gb.iren.presenter;

import java.util.Scanner;

public class ScannerUserInput {
    private final Scanner scanner;

    public ScannerUserInput() {
        this.scanner = new Scanner(System.in);
    }

    public String parseUserInput(){
        return scanner.nextLine();

    }

}
