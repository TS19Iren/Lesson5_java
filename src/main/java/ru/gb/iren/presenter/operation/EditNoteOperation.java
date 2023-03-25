package ru.gb.iren.presenter.operation;

import ru.gb.iren.model.Note;
import ru.gb.iren.model.Notebook;
import ru.gb.iren.view.NotebookView;

import java.time.LocalDateTime;

public class EditNoteOperation implements INotebookPresenterOperation {
    private final Notebook model;
    private final NotebookView view;

    public EditNoteOperation(Notebook model, NotebookView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void operate() {
        if (model.getNotes().isEmpty()) {
            view.printNoNotesToEditMessage();
            return;
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
    }
}
