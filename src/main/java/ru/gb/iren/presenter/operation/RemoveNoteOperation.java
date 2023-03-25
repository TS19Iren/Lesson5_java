package ru.gb.iren.presenter.operation;

import ru.gb.iren.model.Notebook;
import ru.gb.iren.view.NotebookView;

public class RemoveNoteOperation implements INotebookPresenterOperation {
    public RemoveNoteOperation(Notebook model, NotebookView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void operate() {
        model.remove(view.askIndexRemoveNote() - 1);
    }
    private final Notebook model;
    private final NotebookView view;

}
