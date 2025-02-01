package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Reader {
    private static final Logger logger = LogManager.getLogger();
    public String file;
    public String line;
    public HashMap<String, Float> accounts = new HashMap<String, Float>();
    public String criteria = "";

    public Reader(String File) {
        file = File;
    }

    public Reader(String File, String Criteria) {
        file = File;
        criteria = Criteria;
    }

    public void printAccounts() {
        System.out.println(accounts);
    }

    public void createAccounts(String from, String to) {
        accounts.putIfAbsent(from, 0.0f);
        accounts.putIfAbsent(to, 0.0f);
    }

    public void proccessTransaction(Transaction transaction) {
        // First Generates the accounts
        createAccounts(transaction.fromName, transaction.toName);
        // Updates From amount
        
        try {
            float newFromAmount;
            newFromAmount = accounts.get(transaction.fromName) - Float.parseFloat(transaction.amount);
            accounts.put(transaction.fromName, newFromAmount);
        } catch (NumberFormatException e) {
            logger.error(null, "Program failed trying to parse:" + transaction.amount, e, e, e, e, e, e, e, e, transaction, e);
            System.out.println("Failed to Parse Amount Float. Please find transaction: " + transaction.getValues());
        }
        try{
            
        float newToAmount;
        newToAmount = accounts.get(transaction.toName) + Float.parseFloat(transaction.amount);
        accounts.put(transaction.toName, newToAmount);
        }catch(NumberFormatException e)
        {
             logger.error(null, "Program failed trying to parse:" + transaction.amount, e, e, e, e, e, e, e, e, transaction, e);
            System.out.println("Failed to Parse Amount Float. Please find transaction: " + transaction.getValues());
        }
        // updates to amount
        
    }

    public void Run() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                Transaction currentTrransaction = new Transaction(line.split(","));
                proccessTransaction(currentTrransaction);
                listCriteria(criteria, currentTrransaction);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(null, "Program failed at line 61 while reading csv file", e, e, e, e, e, e, e, e, e, e);
        }

        if (criteria.equals("")) {
            printAccounts();
        } else {
            System.out.println(criteria + " owes a total of £" + accounts.get(criteria));
        }

    }

    public void listCriteria(String Criteria, Transaction transaction) {
        if (Criteria.equals(transaction.fromName) || Criteria.equals(transaction.toName)) {
            System.out.println(transaction.getValues());
        }

    }
}
