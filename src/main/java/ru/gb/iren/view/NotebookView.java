package ru.gb.iren.view;

import ru.gb.iren.model.Note;

import java.util.List;

/**
 * Класс для вывода текста в консоль
 */
public class NotebookView {
    private final ScannerUserInput scannerUserInput;

    public NotebookView() {
        this.scannerUserInput = new ScannerUserInput();
    }

    public String showMenu() {
        String menu = """
                1.Show all notes
                2.Edit note
                3.Add new note
                4.Remove note
                5.Write to file
                6.Read from file
                0.Exit
                """;
        return askSomethingAndGetUserInputString(menu);

    }

    public void printAll(List<Note> nb) {
        System.out.println("List of notes:");
        for (int i = 0; i < nb.size(); i++) {
            System.out.println(i + 1 + ". " + nb.get(i));
        }
    }

    public int askIndexEditElem() {
        return getIndex("Enter index of note to edit: ");
    }

    public String askEditTitle() {
        return askSomethingAndGetUserInputString("Enter changed title or press enter if title is not changing: ");
    }

    public String askEditBody() {
        return askSomethingAndGetUserInputString("Enter changed body or press enter if body is not changing: ");
    }

    public String askAddTitle() {
        return askSomethingAndGetUserInputString("Enter  title of added note: ");
    }

    public String askAddBody() {
        return askSomethingAndGetUserInputString("Enter  body of added note: ");
    }

    public void successAddMessage() {
        System.out.println("Note successfully added");
    }

    public int askIndexRemoveNote() {
        return getIndex("Enter index of removing note: ");
    }

    public String askOwnerName() {
        return askSomethingAndGetUserInputString("Enter you name: ");
    }

    public void printNoNotesToEditMessage() {
        System.out.println("There is no notes to edit. Add one before.");
    }

    private String getUserInputString() {
        return scannerUserInput.parseUserInput();
    }

    private String askSomethingAndGetUserInputString(String text) {
        System.out.println(text);
        return getUserInputString();
    }

    private int getIndex(String text) {
        while (true) {
            try {
                System.out.println(text);
                return Integer.parseInt(getUserInputString());
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Enter the integer value");

            }
        }
    }
}
