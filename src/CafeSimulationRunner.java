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
                System.out.print(key + ": " + cafeSimulation.getProducts().get(key));
                int numSpaces = 30;
                for(int i = 0; i < key.length();i++) {
                    numSpaces -= 1;
                }
                for(int i = 0; i < numSpaces; i++) {
                    System.out.print(" ");
                }
                System.out.println("$" + cafeSimulation.getPrices().get(key));
            }
            System.out.println(panel);
            System.out.println("Current bank: $" + (int) (cafeSimulation.getBank() * 100) / 100.0 + "\n" + "Current rent: $" + (int) (cafeSimulation.getRent() * 100) / 100.0);
            System.out.println(panel);
            System.out.println("What do you want to do now?" + "\n" +
                    "(1) Buy products\n" +
                    "(2) Open cafe\n" +
                    "(3) Manage workers");
            int option = Integer.parseInt(userInput.nextLine());
            if(option == 1) {
                System.out.println("What product would you like to buy? ");
                String productBuy = userInput.nextLine();
                if(cafeSimulation.getProducts().containsKey(productBuy)) {
                    System.out.print("How many of " + productBuy + " would you like to buy? ");
                    int productCount = Integer.parseInt(userInput.nextLine());
                    if(cafeSimulation.getBank() - productCount * cafeSimulation.getStockPrices().get(productBuy) >= 0) {
                        cafeSimulation.addProduct(productBuy, productCount);
                        cafeSimulation.changeBank(-1 * cafeSimulation.getStockPrices().get(productBuy) * productCount);
                    } else {
                        System.out.println("You cannot afford this much " + productBuy);
                    }
                }
            } else if(option == 2) {
                cafeSimulation.openStore();
            } else if(option == 3) {
                System.out.println("Current number of workers: " + cafeSimulation.getWorkers());
                System.out.println("Wage: " + cafeSimulation.getWage());
                System.out.println("Would you like to hire or fire workers? \n (1) Hire \n (2) Fire");
                if(Integer.parseInt(userInput.nextLine()) == 1) {
                    System.out.println("How many would you like to hire? ");
                    cafeSimulation.changeWorkers((Integer.parseInt(userInput.nextLine())));
                } else {
                    System.out.println("How many would you like to fire? ");
                    int fireCount = Integer.parseInt(userInput.nextLine());
                    if(cafeSimulation.getWorkers() - fireCount >= 0) {
                        cafeSimulation.changeWorkers(-1 *(Integer.parseInt(userInput.nextLine())));
                    } else {
                        System.out.println("That is more than the current amount of workers in that position!");
                    }
                }
                } else {
                    System.out.println("Not a valid option.");
                }
        }
        System.out.println("Your cafe is bankrupt! Your cafe will be out of business.");
    }
}
