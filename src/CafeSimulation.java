import java.util.Dictionary;
import java.util.Hashtable;
public class CafeSimulation {
    private int difficulty = 1;
    private double bank = 0;
    private Hashtable<String, Integer> products = new Hashtable<>();
    private Hashtable<String, Double> prices = new Hashtable<>();
    public CafeSimulation(int difficulty) {
        this.difficulty = difficulty;
        this.bank = 100 * (difficulty / 25.0);
    }
}
