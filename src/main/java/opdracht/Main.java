package opdracht;

import opdracht.filereader.CSVReader;
import opdracht.filereader.XMLReader;
import opdracht.validation.BalanceValidation;
import opdracht.validation.FindDuplicate;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File fXmlFile = new File("src/main/resources/records.xml");
        XMLReader xmlReader = new XMLReader();
        List<Transaction> xmlTransactions = xmlReader.getTransactions(fXmlFile);

        File csvFile = new File("src/main/resources/records.csv");
        CSVReader csvReader = new CSVReader();
        List<Transaction> csvTransactions = csvReader.getTransactions(csvFile);

        FindDuplicate findDuplicate = new FindDuplicate();
        List<Transaction> xmlDuplicateTransactions = findDuplicate.getDuplicates(xmlTransactions);
        List<Transaction> csvDuplicateTransactions = findDuplicate.getDuplicates(csvTransactions);

        BalanceValidation balanceValidation = new BalanceValidation();
        List<Transaction> xmlIncorrectBalance = balanceValidation.validateBalance(xmlTransactions);
        List<Transaction> csvIncorrectBalance = balanceValidation.validateBalance(csvTransactions);

        PrintReport printReport = new PrintReport();
        printReport.printReport(xmlDuplicateTransactions, xmlIncorrectBalance);
        printReport.printReport(csvDuplicateTransactions, csvIncorrectBalance);
    }

}
