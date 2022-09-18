package commands;

import model.Note;
import model.Notes;

public class DeleteNoteCommand implements ICommand<Integer, Boolean>{
    private final Notes notes;
    public DeleteNoteCommand(Notes notes){
        this.notes = notes;
    }

    @Override
    public Boolean execute(Integer index) {
        notes.deleteNote(index);
        return true;
    }
}
