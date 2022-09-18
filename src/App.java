import model.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private final static String NEKORREKTNIY_VVOD = "некорректный ввод! Нужно ввести номер команды: 1-4,0";
    private final static String BYE = "BYE BYE";
    private static final Presenter presenter = new Presenter();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int code = -1;
        while (code!=0) {
            System.out.println("""
                    '1' - добавить заметку
                    '2' - удалить заметку
                    '3' - открыть заметку
                    '4' - изменить заметку
                    '0' - закрыть программу""");
            try {
                code = scanner.nextInt();
                switch (code) {
                    case 1 -> App.addNewNote(scanner);
                    case 2 -> App.deleteNote(scanner);
                    case 3 -> App.searchByNumber(scanner);
                    case 4 -> App.changeNote(scanner);
                    case 0 -> System.out.println(BYE);
                    default -> {
                        System.out.println(NEKORREKTNIY_VVOD);
                    }
                }
            }catch (InputMismatchException e){
                e.printStackTrace();
                scanner.nextLine();
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
        System.out.println("_____________ЗАМЕТКА " + headerText + " ДОБАВЛЕНА_____________");
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
        int index = scanner.nextInt()-1;
        presenter.showNote(index);
        System.out.println("введите новый текст");
        String newText = scanner.next();
        presenter.changeNote(new Pair(index, newText));
        System.out.println("_________________ЗАМЕТКА ИЗМЕНЕНА____________________");
    }


}