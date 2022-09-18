import model.Body;
import model.Header;
import model.Note;
import model.Priority;

import java.util.Scanner;

public class App {
    public static final Presenter presenter = new Presenter();
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    '1' - добавить заметку
                    '2' - удалить заметку
                    '3' - найти заметку по заголовку""");
            String command = scanner.next();

            switch (command) {
                case "1":
                    App.addNewNote(scanner);
                    break;
                case "2":
                    App.deleteNote(scanner);
                    break;
                case "3":
                    break;
                default:
                    break;
            }
        }
    }

    private static void addNewNote(Scanner scanner){
        System.out.println();
        System.out.println("____________ДОБАВЛЕНИЕ НОВОЙ ЗАМЕТКИ_____________");
        System.out.println("введите заголовок");
        String headerText = scanner.next();
        System.out.println("введите стиль заголовка 0-5");
        int style = scanner.nextInt();
        System.out.println("введите текст заметки");

        String text = scanner.next();
        Note note = new Note(new Header(headerText, style), new Body(text), Priority.GREEN);
        presenter.addNote(note);
        System.out.println("_____________ЗАМЕТКА "+headerText+" ДОБАВЛЕНА_____________");
    }
    private static void deleteNote(Scanner scanner){
        System.out.println();
        System.out.println("____________УДАЛЕНИЕ ЗАМЕТКИ_____________");
        presenter.showAllHeaders();
        System.out.println("введите номер заметки, которую нужно удалить");
        int numberToDelete = scanner.nextInt();
        presenter.deleteNote(numberToDelete-1);
        System.out.println("ЗАМЕТКА УДАЛЕНА");
        System.out.println("СПИСОК ЗАМЕТОК");
        presenter.showAllHeaders();
        System.out.println("__________________________________________");
    }
}