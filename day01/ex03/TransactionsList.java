import java.util.UUID;

public interface TransactionsList {
    void addTransaction(Transaction transaction);
    void rmTransactionById(UUID id);
    Transaction[] TransformToArray();
}
