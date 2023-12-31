import java.io.*;
import java.util.ArrayList;
import java.util.List;


class ToyStore {
    private List<Toy> toys;
    private List<Toy> prizeQueue;
    private ToyStore toyStore;

    public ToyStore() {
        this.toys = new ArrayList<>();
        this.prizeQueue = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateWeight(int toyId, double newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(newWeight);
                break;
            }
        }
    }

    public Toy getRandomToy() {
        double totalWeight = toys.stream().mapToDouble(Toy::getWeight).sum();
        double randomValue = Math.random() * totalWeight;

        for (Toy toy : toys) {
            randomValue -= toy.getWeight();
            if (randomValue <= 0) {
                return toy;
            }
        }

        return null;
    }

    public void saveToFile(Toy toy) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("prizes.txt", true))) {
            writer.println(toy.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addToPrizeQueue(Toy toy) {
        prizeQueue.add(toy);
    }

    public Toy getPrize() {
        if (!prizeQueue.isEmpty()) {
            Toy prize = prizeQueue.remove(0);
            this.saveToFile(prize);
            prize.decreaseQuantity();
            return prize;
        } else {
            System.out.println("Список призовых игрушек пуст.");
            return null;
        }
    }

    public List<Toy> getToys() {
        return toys;
    }
}