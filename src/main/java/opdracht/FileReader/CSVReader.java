package opdracht.FileReader;

import opdracht.Transaction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {

    public List<Transaction> getTransactions(File csvFile) {
        List<List<String>> records = new ArrayList<>();
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }

            for (int i = 1; i < records.size(); i++) {
                int reference = Integer.parseInt(records.get(i).get(0));
                String accountNumber = records.get(i).get(1);
                String description = records.get(i).get(2);
                float startBalance = Float.parseFloat(records.get(i).get(3));
                float mutation = Float.parseFloat(records.get(i).get(4));
                float endBalance = Float.parseFloat(records.get(i).get(5));

                Transaction transaction = new Transaction(reference, accountNumber, startBalance, mutation, endBalance, description);
                transactions.add(transaction);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return transactions;
    }
}
