package ru.gb.iren.view;

/**
 * Класс для вывода текста в консоль
 */
public class NotebookView {

    public void showMenu() {
        String menu = """
                1.Show all notes
                2.Edit note
                3.Add new note
                4.Remove note
                5.Write to file
                6.Read from file
                0.Exit
                """;
        System.out.println(menu);
    }

    public void askIndexEditElem() {
        System.out.println("Enter index of note to edit: ");
    }

    public void askEditTitle() {
        System.out.println("Enter changed title or press enter if title is not changing: ");
    }

    public void askEditBody() {
        System.out.println("Enter changed body or press enter if body is not changing: ");
    }

    public void askAddTitle() {
        System.out.println("Enter  title of added note: ");
    }

    public void askAddBody() {
        System.out.println("Enter  body of added note: ");
    }
    public void successAddMessage(){
        System.out.println("Note successfully added");
    }

    public void askIndexRemoveNote() {
        System.out.println("Enter index of removing note: ");
    }

    public void askOwnerName() {
        System.out.println("Enter you name: ");
    }

    public void printNoNotesToEditMessage() {
        System.out.println("There is no notes to edit. Add one before.");
    }
}
