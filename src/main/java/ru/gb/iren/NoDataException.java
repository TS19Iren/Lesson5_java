package ru.gb.iren;

public class NoDataException extends Exception {
    public NoDataException() {
        super("There is no data in Notebook");
    }
}
