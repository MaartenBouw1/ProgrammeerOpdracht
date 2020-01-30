import opdracht.BalanceValidation;
import opdracht.CSVReader;
import opdracht.Transaction;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BalanceValidationTest {
    private File csvFile = new File("src\\test\\resources\\records.csv");

    @Test
    public void balanceValidationTest() {
        CSVReader csvReader = new CSVReader();
        List<Transaction> transactions = csvReader.getTransactions(csvFile);

        BalanceValidation balanceValidation = new BalanceValidation();
        List<Transaction> incorrectBalance = balanceValidation.validateBalance(transactions);

        assertEquals(1, incorrectBalance.get(0).getEndBalance(), 0.001);

    }
}
