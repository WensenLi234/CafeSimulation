import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
public class CafeSimulation {

    private int difficulty;
    private int days = 0;
    private double bank;
    private double rent;
    private final String[] AVAILABLE_POSITIONS = {
            "Barista",
            "Janitor",
            "Cashier"
    };
    private final String[] AVAILABLE_PRODUCTS = {
            "Beef Curry",
            "Chicken Soup",
            "Steak",
            "Vanilla Sundae",
            "Black Coffee",
            "Latte",
            "Cappucino",

    };
    private final Double[] AVAILABLE_PRICES = {
            13.99, // Beef Curry
            8.95, // Chicken Soup
            16.49, // Steak
            5.49, // Vanilla Sundae
            2.49, // Black Coffee
            3.49, // Latte
            3.49, // Cappucino
    };
    private Hashtable<String, Double> STOCK_PRICES = new Hashtable<>();
    private Hashtable<String, Integer> products = new Hashtable<>();
    private Hashtable<String, Integer> workers = new Hashtable<>();
    private Hashtable<String, Double> prices = new Hashtable<>();

    /**
     * @param difficulty Acts as a multiplier or divisor for certain calculations. Higher is harder.
     */
    public CafeSimulation(int difficulty) {
        this.difficulty = difficulty;
        this.bank = (100 / (1 + difficulty / 10.0));
        this.rent = 10;
        for(String item: this.AVAILABLE_POSITIONS) {
            workers.put(item, 0);
        }
        for(int i = 0; i < AVAILABLE_PRODUCTS.length; i++) {
            products.put(AVAILABLE_PRODUCTS[i], (int) (5 * (3.0 / difficulty)));
            prices.put(AVAILABLE_PRODUCTS[i], AVAILABLE_PRICES[i] * 2);
            STOCK_PRICES.put(AVAILABLE_PRODUCTS[i], AVAILABLE_PRICES[i]);
        }
    }
    public void openStore() {
        for(String product: this.products.keySet()) {
            System.out.println(product);
            int amountSold = (int) (Math.random() * 10 + (workers.get("Barista")) / difficulty);
            if(amountSold > products.get(product)) {
                amountSold = products.get(product);
            }
            products.put(product, products.get(product) - amountSold);
            bank += prices.get(product) * amountSold;
        }
        this.bank -= this.rent;
        this.rent *= 1 + this.difficulty / 10.0;
        this.days += 1;
    }
    /**
     * @return returns a double that represents the amount of money the object has left.
     */
    public double getBank() {
        return bank;
    }

    /**
     * @return returns a double that represents the amount of money deducted from the bank each time the openStore method is called.
     */
    public double getRent() {
        return rent;
    }

    /**
     * @return returns an int that represents the number of days that have passed (number of times the openStore method is called).
     */
    public int getDays() {
        return days;
    }
    /**
     * @return returns a Hashtable representing each position and the number of workers in that position.
     */
    public Hashtable<String, Integer> getWorkers() {
        return workers;
    }

    /**
     * @return returns a Hashtable representing each product and the number of that product.
     */
    public Hashtable<String, Integer> getProducts() {
        return products;
    }

    /**
     * @return
     */
    public Hashtable<String, Double> getPrices() {
        return prices;
    }
    public Hashtable<String, Double> getStockPrices() {
        return STOCK_PRICES;
    }
    public void addProduct(String product, int value) {
        products.put(product, products.get(product) + value);
    }
    public void changeWorker(String worker, int value) {
        workers.put(worker, workers.get(worker) + value);
    }
    public void changeBank(double change) {
        bank += change;
    }
    public void setRent(double result) {
        rent = result;
    }
}
