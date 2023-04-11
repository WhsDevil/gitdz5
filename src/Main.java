import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void printOperations() {
        System.out.println("Выберите индекс операции");
        System.out.println("1 - Добавить элемент в список");
        System.out.println("2 - Показать весь список");
        System.out.println("3 - Удалить элемент из списка");
        System.out.println("4 - Найти по ключевому слову");
    }

    public static void printList(ArrayList<String> list) {
        Iterator<String> iterator = list.iterator();
        System.out.println("Список покупок: ");
        int naturalCount = 1;
        while (iterator.hasNext()) {
            System.out.println(naturalCount++ + " " + iterator.next());
        }
    }

    public static void findInList(String keyWord, ArrayList<String> list) {
        System.out.println("Найдено: ");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toLowerCase().contains(keyWord)) System.out.println((i + 1) + " " + list.get(i));
        }
    }

    public static void main(String[] args) {
        ArrayList<String> shoppingBasket = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printOperations();
            String operationChoice = scanner.nextLine();
            if (operationChoice.equals("end")) break;
            switch (operationChoice) {
                case "1" -> {
                    System.out.println("Какую покупку хотите добавить?");
                    shoppingBasket.add(scanner.nextLine());
                }
                case "2" -> printList(shoppingBasket);
                case "3" -> {
                    printList(shoppingBasket);
                    shoppingBasket.remove(Integer.parseInt(scanner.nextLine()) - 1);
                }
                case "4" -> {
                    System.out.println("Введите текст для поиска ");
                    findInList(scanner.nextLine().toLowerCase(), shoppingBasket);
                }
                default -> System.out.println("Опция введена неверно");
            }
        }
    }
}