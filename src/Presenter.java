import commands.*;
import model.Note;
import model.Notes;
import model.Pair;

public class Presenter {
    private final Notes notes = Notes.getInstance();
    private final ICommand<Note> addNewNoteCommand = new AddNewNoteCommand(notes);
    private final ICommand<Integer> deleteNoteCommand = new DeleteNoteCommand(notes);
    private final ICommand<Integer> showNoteByNumberCommand = new ShowNoteByNumberCommand(notes);
    private final ICommand<Object> showAllHeadersCommand = new ShowAllHeadersCommand(notes);
    private final ICommand<Pair> changeNoteCommand = new ChangeNoteCommand(notes);


    public void addNote(Note note){
        addNewNoteCommand.execute(note);
    }

    public void deleteNote(int index){
        deleteNoteCommand.execute(index);
    }

    public void showNote(int index){
        showNoteByNumberCommand.execute(index);
    }

    public void showAllHeaders(){
        showAllHeadersCommand.execute(null);
    }

    public void changeNote(Pair pair){
        changeNoteCommand.execute(pair);
    }

}
