package commands;

import model.Notes;

import java.util.ArrayList;

public class ShowAllHeadersCommand implements ICommand<Object>{
    private final Notes notes;

    public ShowAllHeadersCommand(Notes notes){
        this.notes = notes;
    }
    @Override
    public void execute(Object o) {
        notes.showAllHeaders();
    }
}
