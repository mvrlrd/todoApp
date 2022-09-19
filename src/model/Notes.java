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
    public void deleteNote(int index){
        noteList.remove(index);
    }
    public void showNote(int index){
        System.out.println(noteList.get(index));
    }

    public void showAllHeaders(){
        for (Note note : noteList){
            System.out.println((noteList.indexOf(note)+1)+"   -   "+note.header.toString()+" "+ note.priority.toString());
        }
    }

}
