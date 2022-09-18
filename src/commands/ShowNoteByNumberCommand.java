package commands;

import model.Notes;

public class ShowNoteByNumberCommand implements ICommand<Integer>{
    private final Notes notes;
    public ShowNoteByNumberCommand(Notes notes){
        this.notes = notes;
    }

    @Override
    public void execute(Integer index) {
        notes.showNote(index);
    }
}
