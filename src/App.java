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
                    '3' - открыть заметку
                    '4' - изменить заметку""");
            int command = scanner.nextInt();

            switch (command) {
                case 1:
                    App.addNewNote(scanner);
                    break;
                case 2:
                    App.deleteNote(scanner);
                    break;
                case 3:
                    App.searchByNumber(scanner);
                    break;
                case 4:
                    App.searchByNumber(scanner);
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

    private static void searchByNumber(Scanner scanner){
        System.out.println();
        System.out.println("____________НАЙТИ ЗАМЕТКУ ПО НОМЕРУ_____________");
        presenter.showAllHeaders();
        System.out.println("введите номер заметки, которую нужно открыть");
        int numberToOpen = scanner.nextInt();
        presenter.showNote(numberToOpen-1);
        System.out.println("________________________________________________");
    }

    private static void changeNote(Scanner scanner){
        System.out.println();
        System.out.println("____________ИЗМЕНИТЬ ЗАМЕТКУ_____________");
        presenter.showAllHeaders();
        System.out.println("введите номер заметки, которую нужно изменить");
        int numberToOpen = scanner.nextInt();
        presenter.showNote(numberToOpen-1);
        String newText = scanner.next();

    }


}