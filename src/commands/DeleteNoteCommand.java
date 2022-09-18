package commands;

import model.Note;
import model.Notes;

public class DeleteNoteCommand implements ICommand{
    private final Note note;
    public DeleteNoteCommand(Note note){
        this.note = note;
    }
    @Override
    public void execute() {
        Notes.getInstance().deleteNote(note);
    }
}
