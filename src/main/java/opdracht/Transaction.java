package opdracht;

public class Transaction {
    private int reference;
    private String accountNumber;
    private float startBalance;
    private float mutation;
    private float endBalance;
    private String description;

    public Transaction(int reference, String accountNumber, float startBalance, float mutation, float endBalance, String description) {
        this.reference = reference;
        this.accountNumber = accountNumber;
        this.startBalance = startBalance;
        this.mutation = mutation;
        this.endBalance = endBalance;
        this.description = description;
    }
}
