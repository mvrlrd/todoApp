package commands;

import model.Note;
import model.Notes;

public class DeleteNoteCommand implements ICommand<Integer>{
    private final Notes notes;
    public DeleteNoteCommand(Notes notes){
        this.notes = notes;
    }

    @Override
    public void execute(Integer index) {
        notes.deleteNote(index);
    }
}
