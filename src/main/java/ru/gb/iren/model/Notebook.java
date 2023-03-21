package ru.gb.iren.model;

import java.io.IOException;
import java.util.List;

/**
 * Класс, описывающий блокнот с записями
 */
public class Notebook {
    private List<Note> notes;
    private final FileWorker<Note> fw;


    public Notebook(String owner) throws IOException {
        String fileName = "_notebookData.txt";
        fw = new FileWorker<>(owner + fileName);
        this.notes = fw.createAndReadIfExist();
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void add(String title, String body) {
        Note note = new Note(title, body);
        notes.add(note);
    }

    public void remove(int index) {
        notes.remove(index);
    }

    public void change(int index, Note note) {
        Note oldNote = notes.get(index);
        oldNote.setTitle(note.getTitle());
        oldNote.setBody(note.getBody());


    }

    public void fileWrite() {
        try {
            fw.writeFile(notes);
        } catch (Exception e) {
            System.out.println("Something is wrong");
        }
    }

    public void fileRead() {
        try {
            notes = fw.readFile();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something is wrong");
        }
    }

    public void printNotes() {
        System.out.println(notes);
    }

    public Note getElemByIndex(int index) {
        return notes.get(index);
    }
}



