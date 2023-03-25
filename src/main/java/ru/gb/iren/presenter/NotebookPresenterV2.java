package ru.gb.iren.presenter;

import ru.gb.iren.model.Notebook;
import ru.gb.iren.presenter.operation.*;
import ru.gb.iren.view.NotebookView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NotebookPresenterV2 implements Runnable {
    private final NotebookView view;

    @Override
    public void run() {
        while (true) {
            String ua = view.showMenu();
            if (!operations.containsKey(ua)) {
                break;
            }
            operations.get(ua).operate();
        }

    }

    private final Map<String, INotebookPresenterOperation> operations;

    public NotebookPresenterV2() throws IOException {
        this.view = new NotebookView();

        Notebook model = new Notebook(view.askOwnerName());
        operations = new HashMap<>();
        operations.put("1", new ShowAllOperation(model, view));
        operations.put("2", new EditNoteOperation(model, view));
        operations.put("3", new AddNoteOperation(model, view));
        operations.put("4", new RemoveNoteOperation(model, view));
        operations.put("5", new ExportDataToFileOperation(model));
        operations.put("6", new ImportDataFromFileOperation(model));

    }
}
