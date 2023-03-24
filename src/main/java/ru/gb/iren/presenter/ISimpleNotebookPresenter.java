package ru.gb.iren.presenter;

import ru.gb.iren.NoDataException;
import ru.gb.iren.model.Note;

import java.util.List;

public interface ISimpleNotebookPresenter<T extends Note> {
List<T> getAll();

    T edit() throws NoDataException;

    T add();

    T remove();


}
