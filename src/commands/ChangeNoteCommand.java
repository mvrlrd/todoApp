package commands;

import model.Notes;
import model.Pair;

public class ChangeNoteCommand implements ICommand<Pair,Boolean> {
    private final Notes notes;

    public ChangeNoteCommand(Notes notes) {
        this.notes = notes;
    }

    @Override
    public Boolean execute(Pair pair) {
        notes.noteList.get(pair.index).body.setText(pair.text);
        return true;
    }
}
