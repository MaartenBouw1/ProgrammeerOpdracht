package opdracht.validation;

import opdracht.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BalanceValidation {

    public List<Transaction> validateBalance(List<Transaction> transactions) {
        List<Transaction> incorrectBalance = new ArrayList<>();

        for (Transaction transaction : transactions) {
            float startBalance = transaction.getStartBalance();
            float mutation = transaction.getMutation();
            float endBalance = Math.round(transaction.getEndBalance());
            float actualBalance = Math.round(startBalance + mutation);

            if (endBalance != actualBalance) {
                incorrectBalance.add(transaction);
            }
        }

        return incorrectBalance;
    }
}
