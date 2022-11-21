import java.util.Hashtable;
import java.util.Scanner;
public class CafeSimulationRunner {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("What would you like the difficulty to be? \n (1) Easy \n (2) Normal \n (3) Hard");
        CafeSimulation cafeSimulation = new CafeSimulation(Integer.parseInt(userInput.nextLine()));
        String panel = "===============";
        while(cafeSimulation.getBank() > 0) {
            System.out.println("Products in stock: ");
            System.out.println(panel);
            for(String key : cafeSimulation.getProducts().keySet()) {
                System.out.println(key + ": " + cafeSimulation.getProducts().get(key));
            }
            System.out.println(panel);
            System.out.println("Current bank: " + cafeSimulation.getBank() + "\n" + "Current rent: " + cafeSimulation.getRent());
            System.out.println(panel);
            System.out.println("What do you want to do now?" + "\n" +
                    "(1) Buy products\n" +
                    "(2) Open store\n" +
                    "(3) Manage workers\n" +
                    "(4) Change prices");
            int option = Integer.parseInt(userInput.nextLine());
            if(option == 1) {
                System.out.println("What product would you like to buy? ");
                String productBuy = userInput.nextLine();
                if(cafeSimulation.getProducts().containsKey(productBuy)) {
                    System.out.print("How many of " + productBuy + " would you like to buy? ");
                    cafeSimulation.addProduct(productBuy, Integer.parseInt(userInput.nextLine()));
                }
            } else if(option == 2) {
                cafeSimulation.openStore();
            } else if(option == 3) {
                System.out.println("Current workers: ");
                for(String key : cafeSimulation.getWorkers().keySet()) {
                    System.out.println(key + ": " + cafeSimulation.getProducts().get(key));
                }
                System.out.println("Which position would you like to manage? \n ");
            } else if(option == 4) {
                System.out.println("What price would you like to change? ");
            } else {
                System.out.println("Not a valid choice.");
            }
        }
    }
}
