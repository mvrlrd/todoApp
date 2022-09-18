package commands;

import model.Note;
import model.Notes;

public class DeleteNoteCommand implements ICommand{
    private  Note note;
    public DeleteNoteCommand(){

    }
    public DeleteNoteCommand(Note note){
        this.note = note;
    }
    public void setNote(Note note) {
        this.note = note;
    }

    public Note getNote() {
        return note;
    }
    @Override
    public void execute() {
        Notes.getInstance().deleteNote(note);
    }
}
