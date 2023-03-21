package ru.gb.iren.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ru.gb.iren.FileNotExistException;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс, описывающий работу с файлом
 *
 * @param <T>
 */
public class FileWorker<T extends Note> {

    private final File f;

    public FileWorker(String fileName) {
        this.f = new File(fileName);
    }

    public List<T> createAndReadIfExist() throws IOException {
        if (f.createNewFile()) {
            final var objects = new ArrayList<T>();
            writeFile(objects);
            return objects;
        }
        return readFile();
    }


    public void writeFile(List<T> notes) throws IOException, FileNotExistException {
        if (!f.exists()) {
            throw new FileNotExistException();
        }
        try (FileWriter fw = new FileWriter(f)) {
            Gson gsonStr = new Gson();
            fw.write(gsonStr.toJson(notes));
        }

    }

    /**
     * Чтение из файла
     */
    public List<T> readFile() throws IOException, FileNotExistException {
        if (!f.exists()) {
            throw new FileNotExistException();
        }
        try (Reader reader = new BufferedReader(new FileReader(f))) {
            Gson gson = new Gson();
            Type listType = TypeToken.getParameterized(List.class, Note.class).getType();
            return gson.fromJson(reader, listType);
        }
    }

}
