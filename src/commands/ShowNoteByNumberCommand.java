package commands;

import model.Note;
import model.Notes;

public class ShowNoteByNumberCommand implements ICommand<Integer, Note>{
    private final Notes notes;
    public ShowNoteByNumberCommand(Notes notes){
        this.notes = notes;
    }

    @Override
    public Note execute(Integer index) {
        notes.showNote(index);
        return notes.noteList.get(index);
    }
}
