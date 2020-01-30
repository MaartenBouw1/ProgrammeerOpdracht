package opdracht;

import java.util.List;

public class PrintReport {
    public void printReport(List<Transaction> duplicateTransactions, List<Transaction> incorrectBalance) {
        System.out.println("The Transaction reference number of these transactions is not unique: ");
        for (Transaction transaction : duplicateTransactions) {
            System.out.println("Reference: " + transaction.getReference());
            System.out.println("Description: " + transaction.getDescription());
            System.out.println("-------------------------------------");
        }
        System.out.println("_________________________________________________________");
        System.out.println("The end balance is not correct on these transactions: ");
        for (Transaction transaction : incorrectBalance) {
            System.out.println("Reference: " + transaction.getReference());
            System.out.println("Description: " + transaction.getDescription());
            System.out.println("Start balance: " + transaction.getStartBalance());
            System.out.println("Mutation: " + transaction.getMutation());
            System.out.println("End balance: " + transaction.getEndBalance());
            System.out.println("-------------------------------------");
        }
        System.out.println();
    }
}
