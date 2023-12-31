import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();
        ToyGame toyGame = new ToyGame(toyStore);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Меню:");
            System.out.println("1 - Добавить игрушку");
            System.out.println("2 - Редактировать игрушку");
            System.out.println("3 - Розыгрыш игрушек");
            System.out.println("4 - Список выигранных игрушек");
            System.out.println("0 - Выход");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Введите ID игрушки:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Введите название игрушки:");
                    String name = scanner.nextLine();
                    System.out.println("Введите количество игрушек:");
                    int quantity = scanner.nextInt();
                    System.out.println("Введите вес игрушки (в %):");
                    double weight = scanner.nextDouble();

                    toyStore.addToy(new Toy(id, name, quantity, weight));
                    System.out.println("Игрушка добавлена.");
                    break;

                case 2:
                    System.out.println("Введите ID игрушки для редактирования веса:");
                    int editId = scanner.nextInt();
                    System.out.println("Введите новый вес игрушки (в %):");
                    double newWeight = scanner.nextDouble();

                    toyStore.updateWeight(editId, newWeight);
                    System.out.println("Вес игрушки обновлен.");
                    break;

                case 3:
                    System.out.println("Сколько игрушек розыграть?");
                    int numberOfPrizes = scanner.nextInt();
                    toyGame.addToPrizeQueue(numberOfPrizes);
                    toyGame.distributePrizes(numberOfPrizes);
                    break;

                case 4:
                    System.out.println("Список выигранных игрушек:");
                    List<Toy> wonToys = toyStore.getToys();
                    for (Toy toy : wonToys) {
                        System.out.println(toy.getName());
                    }
                    break;

                case 0:
                    System.out.println("Программа завершена.");
                    System.exit(0);

                default:
                    System.out.println("Неверный ввод. Попробуйте еще раз.");
            }
        }
    }
}