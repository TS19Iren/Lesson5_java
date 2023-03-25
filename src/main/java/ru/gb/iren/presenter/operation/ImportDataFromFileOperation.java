
package ru.gb.iren.presenter.operation;

import ru.gb.iren.model.Notebook;

public class ImportDataFromFileOperation implements INotebookPresenterOperation {
    private final Notebook model;

    public ImportDataFromFileOperation(Notebook model) {
        this.model = model;
    }

    @Override
    public void operate() {
        model.fileRead();

    }
}
