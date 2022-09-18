package commands;

import model.Note;
import model.Notes;

public class AddNewNoteCommand implements ICommand {
    private Note note;

    public AddNewNoteCommand(){
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public Note getNote() {
        return note;
    }

    public AddNewNoteCommand(Note note){
        this.note = note;
    }
    @Override
    public void execute() {
        Notes.getInstance().addNewNote(note);
    }
}
