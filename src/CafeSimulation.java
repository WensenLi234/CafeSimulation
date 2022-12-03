
import java.util.Hashtable;
public class CafeSimulation {

    private int difficulty;
    private int workers;
    private double wage;
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
    private Hashtable<String, Double> stockPrices = new Hashtable<>();
    private Hashtable<String, Integer> products = new Hashtable<>();
    private Hashtable<String, Double> prices = new Hashtable<>();

    /**
     * @param difficulty Acts as a multiplier or divisor for certain calculations. Higher is harder.
     */
    public CafeSimulation(int difficulty) {
        this.difficulty = difficulty;
        this.bank = (100 / (1 + difficulty / 10.0));
        this.rent = 10;
        this.workers = 0;
        this.wage = 25.0 * difficulty;
        for(int i = 0; i < AVAILABLE_PRODUCTS.length; i++) {
            products.put(AVAILABLE_PRODUCTS[i], (int) (5 * (3.0 / difficulty)));
            prices.put(AVAILABLE_PRODUCTS[i], AVAILABLE_PRICES[i] * 2);
            stockPrices.put(AVAILABLE_PRODUCTS[i], AVAILABLE_PRICES[i]);
        }
    }

    /**
     * Opens the store. This will serve as the end of the gameplay loop.
     */
    public void openStore() {
        for(String product: this.products.keySet()) {
            System.out.println(product);
            int amountSold = (int) (Math.random() * 5 + workers / difficulty);
            if(amountSold > products.get(product)) {
                amountSold = products.get(product);
            }
            products.put(product, products.get(product) - amountSold);
            bank += prices.get(product) * amountSold;
        }
        this.bank -= this.rent + this.workers;
        this.rent *= 1 + this.difficulty / 10.0;
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
     * @return returns a Hashtable representing each position and the number of workers in that position.
     */
    public int getWorkers() {
        return workers;
    }
    public double getWage() {
        return wage;
    }

    /**
     * @return returns a Hashtable representing each product and the number of that product.
     */
    public Hashtable<String, Integer> getProducts() {
        return products;
    }

    /**
     * @return returns a Hashtable representing each product and its respective price.
     */
    public Hashtable<String, Double> getPrices() {
        return prices;
    }

    /**
     * @return returns a Hashtable representing each product and its respective stock price.
     */
    public Hashtable<String, Double> getStockPrices() {
        return stockPrices;
    }
    /**
     * @param product The key in products.
     * @param value the value added onto product.
     */
    public void addProduct(String product, int value) {
        products.put(product, products.get(product) + value);
    }

    /**
     * @param value The value added onto workers.
     */
    public void changeWorkers(int value) {

        workers += value;
    }

    /**
     * Adds change to the bank.
     * @param change amount that will be added onto bank.
     */
    public void changeBank(double change) {
        bank += change;
    }
}
