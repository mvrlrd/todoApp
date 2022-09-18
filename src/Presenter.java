import commands.AddNewNoteCommand;
import commands.DeleteNoteCommand;
import commands.ShowAllHeadersCommand;
import commands.ShowNoteByNumberCommand;
import model.Note;
import model.Notes;

public class Presenter {
    private final Notes notes = Notes.getInstance();
    private final AddNewNoteCommand addNewNoteCommand = new AddNewNoteCommand(notes);
    private final DeleteNoteCommand deleteNoteCommand = new DeleteNoteCommand(notes);
    private final ShowNoteByNumberCommand showNoteByNumberCommand = new ShowNoteByNumberCommand(notes);
    private final ShowAllHeadersCommand showAllHeadersCommand = new ShowAllHeadersCommand(notes);


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

}
