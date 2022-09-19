package commands;

import model.Notes;

public class ShowAllHeadersCommand implements ICommand<Object, Integer>{
    private final Notes notes;

    public ShowAllHeadersCommand(Notes notes){
        this.notes = notes;
    }
    @Override
    public Integer execute(Object o) {
        notes.showAllHeaders();
        return notes.noteList.size();
    }
}
