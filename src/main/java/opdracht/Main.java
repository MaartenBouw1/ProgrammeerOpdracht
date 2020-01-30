package opdracht;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        File fXmlFile = new File("src\\main\\resources\\records.xml");
        XMLReader xmlReader = new XMLReader();
        List<Transaction> transactions = xmlReader.getTransactions(fXmlFile);

        FindDuplicate findDuplicate = new FindDuplicate();
        List<Transaction> duplicateTransactions = findDuplicate.getDuplicates(transactions);

        BalanceValidation balanceValidation = new BalanceValidation();
        List<Transaction> incorrectBalance = balanceValidation.validateBalance(transactions);

        System.out.println("The Transaction reference number of these transactions is not unique: ");
        for (Transaction transaction: duplicateTransactions) {
            System.out.println("Reference: " + transaction.getReference());
            System.out.println("Description: " + transaction.getDescription());
        }
        System.out.println("_________________________________________________________");
        System.out.println("The end balance is not correct on these transactions: ");
        for (Transaction transaction: incorrectBalance) {
            System.out.println("Reference: " + transaction.getReference());
            System.out.println("Description: " + transaction.getDescription());
            System.out.println("Start balance: " + transaction.getStartBalance());
            System.out.println("Mutation: " + transaction.getMutation());
            System.out.println("End balance: " + transaction.getEndBalance());
            System.out.println("-------------------------------------");
        }
    }

}
