package ru.gb.iren.presenter;

import ru.gb.iren.NoDataException;
import ru.gb.iren.model.Note;
import ru.gb.iren.model.Notebook;
import ru.gb.iren.view.NotebookView;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class NotebookPresenterV2 implements Runnable, ISimpleNotebookPresenter<Note>, ISimpleNotebookFileWorker<Note> {
    private final NotebookView view;
    private final Notebook model;

    @Override
    public void run() {
        boolean isRun = true;
        while (isRun) {

            String ua = view.showMenu();
            ;
            switch (ua) {
                case "1" -> this.getAll();
                case "2" -> {
                    try {
                        this.edit();
                    } catch (NoDataException e) {
                        view.printNoNotesToEditMessage();
                    }
                }
                case "3" -> {
                    this.add();
                }
                case "4" -> {
                    this.remove();
                }
                case "5" -> this.write();
                case "6" -> this.read();
                default -> isRun = false;
            }
        }
    }

    public NotebookPresenterV2() throws IOException {
        this.view = new NotebookView();

        this.model = new Notebook(view.askOwnerName());

    }


    @Override
    public List<Note> read() {
        model.fileRead();
        return model.getNotes();
    }

    @Override
    public void write() {
        model.fileWrite();
    }

    @Override
    public List<Note> getAll() {
        final var notes = model.getNotes();
        view.printAll(notes);
        return notes;
    }

    @Override
    public Note edit() throws NoDataException {
        if (model.getNotes().isEmpty()) {
            view.printNoNotesToEditMessage();
            throw new NoDataException();
        }
        int indexEditElem = view.askIndexEditElem();

        var elemByIndex = model.getElemByIndex(indexEditElem - 1);
        String title = elemByIndex.getTitle();
        String body = elemByIndex.getBody();
        LocalDateTime createTime = elemByIndex.getCreateTime();

        var editBody = view.askEditBody();
        if (editBody.isEmpty() || editBody.isBlank()) {
            editBody = body;
        }
        Note newNote = new Note(title, editBody, createTime);
        model.change(indexEditElem - 1, newNote);
        return newNote;
    }

    @Override
    public Note add() {
        final var title = view.askAddTitle();
        String body = view.askAddBody();
        final var note = new Note(title, body);
        model.add(note);
        view.successAddMessage();
        return note;
    }

    @Override
    public Note remove() {
        final var index = view.askIndexRemoveNote();
        final var elemByIndex = model.getElemByIndex(index-1);
        model.remove(index-1);
        return elemByIndex;
    }

}
