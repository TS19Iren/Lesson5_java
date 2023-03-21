package ru.gb.iren;

public class FileNotExistException extends RuntimeException {
    public FileNotExistException() {
        super("File does not exist. You need to call the createAndReadIfExist method.");
    }
}
