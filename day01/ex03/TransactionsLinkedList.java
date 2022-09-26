import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
    Transaction_Node head = null;

    @Override
    public void addTransaction(Transaction transaction) {
        Transaction_Node transaction_node = new Transaction_Node(transaction, head);
        head = transaction_node;

    }

    @Override
    public void rmTransactionById(UUID id) throws TransactionNotFoundException {
        Transaction_Node tmp = head;
        Transaction_Node tmp2 = head;
        for (int i = 0; tmp != null; tmp = tmp.getTranNext(), i++) {

            if (tmp.getTransaction().getIdentifier() == id) {
                if (i == 0) {
                    tmp = tmp.getTranNext();
                    head = tmp;
                    return ;
                }
                if (tmp.getTranNext() == null) {
                    tmp2.setTranNext(null);
                    return ;
                }
                tmp2.setTranNext(tmp.getTranNext());
                return ;
            }
            tmp2 = tmp;
        }

        throw new TransactionNotFoundException("Wrong ID");
    }

    @Override
    public Transaction[] TransformToArray() {
        Transaction_Node tmp = head;
        int i;
        for (i = 0; tmp != null; tmp = tmp.getTranNext(), i++) {
            continue;
        }
        tmp = head;
        Transaction[] transactionArray = new Transaction[i];
        for (i = 0; tmp != null; tmp = tmp.getTranNext(), i++) {
            transactionArray[i] = tmp.getTransaction();
        }
        return transactionArray;
    }
}


class Transaction_Node {
    private Transaction transaction;
    private Transaction_Node tranNext;

    public Transaction_Node(Transaction transaction, Transaction_Node tranNext) {
        this.transaction = transaction;
        this.tranNext = tranNext;
    }

    public Transaction_Node getTranNext() {
        return tranNext;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTranNext(Transaction_Node tranNext) {
        this.tranNext = tranNext;
    }
}

