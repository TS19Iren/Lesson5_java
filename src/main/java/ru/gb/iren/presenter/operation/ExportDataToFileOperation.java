package ru.gb.iren.presenter.operation;

import ru.gb.iren.model.Notebook;

public class ExportDataToFileOperation implements INotebookPresenterOperation {
    private final Notebook model;

    public ExportDataToFileOperation(Notebook model) {
        this.model = model;
    }

    @Override
    public void operate() {
        model.fileWrite();
    }
}
