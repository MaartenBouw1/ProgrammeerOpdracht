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
        for (Transaction transaction : duplicateTransactions) {
            System.out.println(duplicateTransactions);
        }
    }

}
