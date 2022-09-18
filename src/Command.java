import model.Note;

public interface Command {
     boolean addNewNote();
     boolean deleteNote();
     Note showNote();
}
