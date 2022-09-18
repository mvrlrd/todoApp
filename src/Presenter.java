import commands.AddNewNoteCommand;
import commands.DeleteNoteCommand;
import commands.ShowNoteCommand;
import model.Note;

public class Presenter {
    private final AddNewNoteCommand addNewNoteCommand = new AddNewNoteCommand();
    private final DeleteNoteCommand deleteNoteCommand = new DeleteNoteCommand();
    private final ShowNoteCommand showNoteCommand = new ShowNoteCommand();

    public void addNote(Note note){
        addNewNoteCommand.setNote(note);
        addNewNoteCommand.execute();
    }

    public void deleteNote(Note note){
        deleteNoteCommand.setNote(note);
        deleteNoteCommand.execute();
    }

    public void showNote(String headerText){
        showNoteCommand.setHeaderText(headerText);
        showNoteCommand.execute();
    }

}
