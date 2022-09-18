package commands;

import model.Note;
import model.Notes;

public class AddNewNoteCommand implements ICommand {
    private final Note note;
    public AddNewNoteCommand(Note note){
        this.note = note;
    }
    @Override
    public void execute() {
        Notes.getInstance().addNewNote(note);
    }
}
