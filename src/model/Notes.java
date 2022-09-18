package model;

import java.util.ArrayList;

public class Notes {
    private static Notes INSTANCE;
    public final ArrayList<Note> noteList = new ArrayList<>();

    private Notes() {}

    public static Notes getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Notes();
        }
        return INSTANCE;
    }

    public void addNewNote(Note note){
        noteList.add(note);
    }
    public void deleteNote(Note note){
        noteList.remove(note);
    }
    public Note showNote(String header){
        return getNoteByHeader(header);
    }

    private Note getNoteByHeader(String text){
        for (Note note : noteList){
            if (note.header.equals(text)){
                return note;
            }
        }
        return null;
    }

}
