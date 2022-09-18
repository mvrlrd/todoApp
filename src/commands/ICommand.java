package commands;

import model.Note;

public interface ICommand<T,K> {
    K execute(T t);
}
