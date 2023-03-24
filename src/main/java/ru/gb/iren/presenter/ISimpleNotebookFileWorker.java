package ru.gb.iren.presenter;

import ru.gb.iren.model.Note;

import java.util.List;

public interface ISimpleNotebookFileWorker<T extends Note> {
    List<T> read();

    void write();
}
