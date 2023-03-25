package ru.gb.iren.presenter.operation;

import ru.gb.iren.model.Notebook;
import ru.gb.iren.view.NotebookView;

public class ShowAllOperation implements INotebookPresenterOperation {
    private final Notebook model;
    private final NotebookView view;

    public ShowAllOperation(Notebook model, NotebookView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void operate() {
        view.printAll(model.getNotes());
    }
}
