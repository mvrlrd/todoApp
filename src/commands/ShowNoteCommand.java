package commands;

import model.Note;
import model.Notes;

public class ShowNoteCommand implements ICommand<String>{
    private final Notes notes;
    public ShowNoteCommand(Notes notes){
        this.notes = notes;
    }

    @Override
    public void execute(String headerText) {
        System.out.println(notes.showNote(headerText));
    }
}
