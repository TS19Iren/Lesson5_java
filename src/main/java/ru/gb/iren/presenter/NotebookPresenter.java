package ru.gb.iren.presenter;

import ru.gb.iren.model.Note;
import ru.gb.iren.model.Notebook;
import ru.gb.iren.view.NotebookView;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Класс, описывающий взаимодействие пользовательского класса (ввода данных) и
 * модели данных
 */
public class NotebookPresenter {
    private final ScannerUserInput scannerUserInput;
    private final NotebookView nv;
    private Notebook nb;

    public NotebookPresenter() {
        this(null);

    }

    public NotebookPresenter(Notebook nb) {
        this.nv = new NotebookView();
        this.nb = nb;
        this.scannerUserInput = new ScannerUserInput();
    }

    public void showAll() {
        nb.printNotes();
    }

    public void start() throws IOException {
        boolean isRun = true;
        while (isRun) {
            if (nb == null) {
                String owner;
                nv.askOwnerName();
                owner = scannerUserInput.parseUserInput();
                nb = new Notebook(owner);
            }
            nv.showMenu();
            String ua = scannerUserInput.parseUserInput();
            switch (ua) {
                case "1" -> showAll();
                case "2" -> {
                    if (nb.getNotes().isEmpty()) {
                        nv.printNoNotesToEditMessage();
                        break;
                    }
                    nv.askIndexEditElem();
                    int userIndex = Integer.parseInt(scannerUserInput.parseUserInput());
                    final var elemByIndex = nb.getElemByIndex(userIndex - 1);
                    nv.askEditTitle();
                    ua = scannerUserInput.parseUserInput();
                    String title = elemByIndex.getTitle();
                    String body = elemByIndex.getBody();
                    LocalDateTime createTime = elemByIndex.getCreateTime();
                    if (ua != null && !ua.equals("")) {
                        title = ua;
                    }
                    nv.askEditBody();
                    ua = scannerUserInput.parseUserInput();
                    if (ua != null && !ua.equals("")) {
                        body = ua;
                    }
                    Note newNote = new Note(title, body,createTime);
                    nb.change(userIndex - 1, newNote);
                }
                case "3" -> {

                    nv.askAddTitle();
                    String title = scannerUserInput.parseUserInput();
                    nv.askAddBody();
                    String body = scannerUserInput.parseUserInput();
                    nb.add(title, body);

                }
                case "4" -> {
                    nv.askIndexRemoveNote();
                    int userIndex = Integer.parseInt(scannerUserInput.parseUserInput());
                    nb.remove(userIndex - 1);
                }
                case "5" -> nb.fileWrite();
                case "6" -> nb.fileRead();
                default -> isRun = false;

            }
        }
    }
}
