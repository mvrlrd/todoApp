package commands;

import model.Notes;

public class ShowNoteCommand implements ICommand{
    private final String headerText;
    public ShowNoteCommand(String headerText){
        this.headerText = headerText;
    }
    @Override
    public void execute() {
        Notes.getInstance().showNote(headerText);
    }
}
