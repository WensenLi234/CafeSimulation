import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
public class CafeSimulation {
    private int difficulty = 1;
    private int days = 0;
    private double bank = 0;
    private double rent = 0;
    private final String[] availablePositions = {
            "Cook",
            "Barista",
            "Janitor",
            "Cashier"
    };
    private final String[] availableProducts = {
            "Beef Curry",
            "Chicken soup",
            "",
            "Vanilla Sundae",
            "Black Coffee",
            "Latte",
            "Cappucino",

    };
    private final Double[] availablePrices = {};
    private Hashtable<String, Integer> products = new Hashtable<>();
    private Hashtable<String, Integer> workers = new Hashtable<>();
    private Hashtable<String, Double> prices = new Hashtable<>();
    private Hashtable<String, Double> stockPrices = new Hashtable<>();
    public CafeSimulation(int difficulty) {
        this.difficulty = difficulty;
        this.bank = 100 / (1 + difficulty / 10.0);
        this.rent = 10 * (1 + difficulty / 10.0);
        for(String item: availablePositions) {
            workers.put(item, 0);
        }

    }
    public double getBank() {
        return bank;
    }
    public double getRent() {
        return rent;
    }
    public Hashtable<String, Integer> getWorkers() {
        return workers;
    }
    public Hashtable<String, Integer> getProducts() {
        return products;
    }
    public Hashtable<String, Double> getPrices() {
        return prices;
    }
    public Hashtable<String, Double> getStockPrices() {
        return stockPrices;
    }
}
