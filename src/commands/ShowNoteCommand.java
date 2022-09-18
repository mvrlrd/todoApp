package commands;

import model.Note;
import model.Notes;

public class ShowNoteCommand implements ICommand{
    private  String headerText;
    public ShowNoteCommand(){

    }
    public void setHeaderText(String text) {
        this.headerText = text;
    }

    public String getHeaderText() {
        return headerText;
    }
    public ShowNoteCommand(String headerText){
        this.headerText = headerText;
    }
    @Override
    public void execute() {
        System.out.println(Notes.getInstance().showNote(headerText));
    }
}
