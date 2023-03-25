package ru.gb.iren.presenter.operation;

import ru.gb.iren.model.Note;
import ru.gb.iren.model.Notebook;
import ru.gb.iren.view.NotebookView;

public class AddNoteOperation implements INotebookPresenterOperation {
    private final Notebook model;
    private final NotebookView view;

    public AddNoteOperation(Notebook model, NotebookView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void operate() {
        final var title = view.askAddTitle();
        String body = view.askAddBody();
        final var note = new Note(title, body);
        model.add(note);
        view.successAddMessage();
    }
}
