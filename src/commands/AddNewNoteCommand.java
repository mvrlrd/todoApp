package commands;

import model.Note;
import model.Notes;

public class AddNewNoteCommand implements ICommand<Note,Boolean> {
    private final Notes notes;

    public AddNewNoteCommand(Notes notes){
        this.notes = notes;
    }

    @Override
    public Boolean execute(Note note) {
        notes.addNewNote(note);
        return true;
    }
}
