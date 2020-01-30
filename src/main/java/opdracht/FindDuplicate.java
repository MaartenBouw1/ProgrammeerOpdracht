package opdracht;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicate {

    public List<Transaction> getDuplicates(List<Transaction> transactions) {
        List<Transaction> returnTransactions = new ArrayList<>();
        for (int i = 0; i < transactions.size(); i++) {
            for (int j = i + 1; j < transactions.size(); j++) {
                if (transactions.get(i).getReference() == transactions.get(j).getReference()) {
                    returnTransactions.add(transactions.get(i));
                    returnTransactions.add(transactions.get(j));
                }
            }
        }

        return returnTransactions;
    }
}
