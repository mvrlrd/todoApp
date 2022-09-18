import model.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private final static String NEKORREKTNIY_VVOD = "некорректный ввод! Нужно ввести номер команды: 1-4,0";
    private final static int STYLES_NUM = 5;
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
                    '5' - все заметки
                    '0' - закрыть программу""");
            try {
                code = scanner.nextInt();
                switch (code) {
                    case 1 -> App.addNewNote(scanner);
                    case 2 -> App.deleteNote(scanner);
                    case 3 -> App.searchByNumber(scanner);
                    case 4 -> App.changeNote(scanner);
                    case 5 -> App.showAll(scanner);
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
    private static int getInputNumber(Scanner scanner, String errorMsg, int limit) {
        while (true)
            try {
                int num = scanner.nextInt();
                if ((num>limit)||(num<=0)){
                    throw new InputMismatchException();
                }else{
                    return num-1;
                }
            } catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.println(errorMsg);
                scanner.nextLine();
            }
    }

    private static void addNewNote(Scanner scanner) {
        System.out.println();
        System.out.println("____________ДОБАВЛЕНИЕ НОВОЙ ЗАМЕТКИ_____________");
        System.out.println("введите заголовок");
        String headerText = scanner.next();
        System.out.println("введите стиль заголовка 0-"+STYLES_NUM);
        int style = getInputNumber(scanner, "Стиль текста может быть 0-"+STYLES_NUM,STYLES_NUM);
        System.out.println("введите текст заметки");
        String text = scanner.next();
        System.out.println("выберите приоритет заметки 2 - High, 1 - Low");
        int prioritet = getInputNumber(scanner, "приоритет может быть 1 или 2", 2);
        Note note = new Note(new Header(headerText, style), new Body(text), Priority.LOW);
        if (prioritet == 1) {
            note.priority = Priority.HIGH;
        }
        presenter.addNote(note);
        System.out.println("_____________ЗАМЕТКА " + headerText + " ДОБАВЛЕНА_____________");
    }

    private static void deleteNote(Scanner scanner){
        System.out.println();
        System.out.println("____________УДАЛЕНИЕ ЗАМЕТКИ_____________");
        int size = presenter.showAllHeaders();
        if (size>0) {
            System.out.println("введите номер заметки, которую нужно удалить c 1-"+size);
            int numberToDelete = getInputNumber(scanner, "возможные индексы: 1-" + size, size);
            presenter.deleteNote(numberToDelete);
            System.out.println("ЗАМЕТКА УДАЛЕНА");
            System.out.println("СПИСОК ЗАМЕТОК");
            presenter.showAllHeaders();
        }else {
            System.out.println("нет заметок");
        }
        System.out.println("__________________________________________");
    }

    private static void searchByNumber(Scanner scanner){
        System.out.println();
        System.out.println("____________НАЙТИ ЗАМЕТКУ ПО НОМЕРУ_____________");
        int size = presenter.showAllHeaders();
        if (size>0) {
            System.out.println("введите номер заметки, которую нужно открыть 1-" + size);
            int numberToOpen = getInputNumber(scanner, "сейчас доступны 1-" + size, size);
            presenter.showNote(numberToOpen);
        }else {
            System.out.println("нет заметок");
        }
        System.out.println("________________________________________________");
    }

    private static void changeNote(Scanner scanner){
        System.out.println();
        System.out.println("____________ИЗМЕНИТЬ ЗАМЕТКУ_____________");
        int size = presenter.showAllHeaders();
        if (size>0) {
            System.out.println("введите номер заметки, которую нужно изменить c 1-"+size);
            int index = getInputNumber(scanner, "сейчас доступны заметки с 1-"+size, size);
            presenter.showNote(index);
            System.out.println("введите новый текст");
            String newText = scanner.next();
            presenter.changeNote(new Pair(index, newText));
        }else{
            System.out.println("нет заметок");
        }
        System.out.println("_________________ЗАМЕТКА ИЗМЕНЕНА____________________");
    }

    private static void showAll(Scanner scanner){
        System.out.println();
        System.out.println("____________СПИСОК ВСЕХ ЗАМЕТОК_____________");
        int size = presenter.showAllHeaders();
        if (size==0) {
            System.out.println("нет заметок");
        }
        System.out.println("________________________________________________");
    }

}