package BE;

public class PiggyBank {

    private int[] coins;
    private int[] totalCoinsPerType;

    public PiggyBank() {
        coins = new int[6];
        totalCoinsPerType = new int[coins.length];
        this.initCoins();
    }

    private void initCoins() {
        this.coins[0] = 50;
        this.coins[1] = 100;
        this.coins[2] = 200;
        this.coins[3] = 500;
        this.coins[4] = 1000;
        this.coins[5] = 2000;
    }

    public String getPiggyBankAccount() {
        int total = 0;
        for (int i = 0; i < coins.length; i++)
            total += coins[i] * totalCoinsPerType[i];
        return "You have save a total of: ₡ " + total + "\n";
    }

    public String getSpecificCoin(int coinIndex) {
        return "Coin: " + this.coins[coinIndex] + " total: " + coins[coinIndex] * totalCoinsPerType[coinIndex] + " quantity: " + totalCoinsPerType[coinIndex] + "\n";
    }

    public String insertCoins(int coinIndex, int quantity) {
        totalCoinsPerType[coinIndex] += quantity;

        return "You have save: " + quantity + " of " + coins[coinIndex];
    }

    public int[] getCoins() {
        return coins;
    }

    public void setCoins(int[] coins) {
        this.coins = coins;
    }
}
