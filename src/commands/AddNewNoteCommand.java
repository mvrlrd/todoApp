package commands;

import model.Note;
import model.Notes;

public class AddNewNoteCommand implements ICommand<Note> {
    private final Notes notes;

    public AddNewNoteCommand(Notes notes){
        this.notes = notes;
    }

    @Override
    public void execute(Note note) {
        notes.addNewNote(note);
    }
}
