package commands;

import model.Note;

public interface ICommand<T> {
    void execute(T t);
}
