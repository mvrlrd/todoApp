package commands;


public interface ICommand<T,K> {
    K execute(T t);
}
