import java.util.Hashtable;
import java.util.Scanner;
public class CafeSimulationRunner {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("What would you like the difficulty to be: ");
        CafeSimulation cafeSimulation = new CafeSimulation(userInput.nextInt());
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
                    "(1) Buy products" + "\n" +
                    "(2) Open store" + "\n" +
                    "(3) Manage workers" + "\n" +
                    "(4) Change prices");
            int option = userInput.nextInt();
            if(option == 1) {
                System.out.print("What product would you like to buy? ");
                String productBuy = userInput.nextLine();
                if(cafeSimulation.getProducts().containsKey(productBuy)) {
                    System.out.print("How many of " + productBuy + " would you like to buy?");
                    cafeSimulation.getProducts().put(productBuy, userInput.nextInt());
                }
            } else if(option == 2) {
                cafeSimulation.openStore();
            } else if(option == 3) {

            } else if(option == 4) {

            } else {
                System.out.println("Not a valid choice.");
            }
        }
    }
}
