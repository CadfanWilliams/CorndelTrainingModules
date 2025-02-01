package app;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        logger.info("The user started up the program");
        System.out.println("Would you like to list all the accounts or search for an account?");
        System.out.println("Enter 'All' to list all or accounts or enter your criteria to search for it");
        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine();

        if (userChoice.equals("All")) {
            Reader reader = new Reader("DodgyTransactions2015.csv");
            reader.Run();
        } else if (!userChoice.isEmpty()) {
            Reader reader = new Reader("DodgyTransactions2015.csv", userChoice);
            reader.Run();
        }
        scanner.close();
        
        
    }
}
