package opdracht.validation;

import opdracht.Transaction;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicate {

    public List<Transaction> getDuplicates(List<Transaction> transactions) {
        List<Transaction> returnTransactions = new ArrayList<>();
        for (int i = 0; i < transactions.size(); i++) {
            for (int j = i + 1; j < transactions.size(); j++) {
                if (transactions.get(i).getReference() == transactions.get(j).getReference()) {
                    if (isUnique(returnTransactions, transactions.get(i))) {
                        returnTransactions.add(transactions.get(i));
                    }
                    if (isUnique(returnTransactions, transactions.get(j))) {
                        returnTransactions.add(transactions.get(j));
                    }
                }
            }
        }

        return returnTransactions;
    }

    private boolean isUnique(List<Transaction> transactions, Transaction checkDuplicate) {
        for (Transaction transaction : transactions) {
            if (transaction.getDescription().equals(checkDuplicate.getDescription())) {
                return false;
            }
        }
        return true;
    }
}
