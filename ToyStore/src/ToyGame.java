
class ToyGame {
    private ToyStore toyStore;

    public ToyGame(ToyStore toyStore) {
        this.toyStore = toyStore;
    }

    public void addToPrizeQueue(int numberOfPrizes) {
        for (int i = 0; i < numberOfPrizes; i++) {
            Toy prize = toyStore.getRandomToy();
            if (prize != null) {
                toyStore.addToPrizeQueue(prize);
            }
        }
    }

    public void distributePrizes(int numberOfPrizes) {
        for (int i = 0; i < numberOfPrizes; i++) {
            Toy prize = toyStore.getPrize();
            if (prize != null) {
                System.out.println("Выдана игрушка: " + prize.getName());
            } else {
                System.out.println("Не удалось выдать приз.");
            }
        }
    }
}
