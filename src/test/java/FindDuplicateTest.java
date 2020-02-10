import opdracht.validation.FindDuplicate;
import opdracht.Transaction;
import opdracht.filereader.XMLReader;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FindDuplicateTest {
    private File fXmlFile = new File("src/test/resources/records.xml");

    @Test
    public void testDuplicateReferences() {
        XMLReader xmlReader = new XMLReader();
        List<Transaction> transactions = xmlReader.getTransactions(fXmlFile);

        FindDuplicate findDuplicate = new FindDuplicate();
        List<Transaction> duplicateTransactions = findDuplicate.getDuplicates(transactions);

        assertEquals(123456, duplicateTransactions.get(0).getReference());
    }
}
