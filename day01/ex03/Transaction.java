import java.util.UUID;

public class Transaction {
    private enum Transfer_category {
        Debits, Credits
    }

    private UUID Identifier;
    private User Recipient;
    private User Sender;
    private int Transfer_amount;
    private Transfer_category tc;

    public Transaction(User recipient, User sender, int transfer_amount) {
        Identifier = UUID.randomUUID();
        Recipient = recipient;
        Sender = sender;
        Transfer_amount = transfer_amount;
        if (Sender.getBalance() >= transfer_amount) {
           if (transfer_amount > 0)
                setTc(Transfer_category.Debits);
           else
               setTc(Transfer_category.Credits);
        }
        else {
            System.out.println("don't enough money!");
        }


    }

    public Transfer_category getTc() {
        return tc;
    }

    public void setTc(Transfer_category tc) {
        this.tc = tc;
    }

    public UUID getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(UUID identifier) {
        Identifier = identifier;
    }

    public User getRecipient() {
        return Recipient;
    }

    public void setRecipient(User recipient) {
        Recipient = recipient;
    }

    public User getSender() {
        return Sender;
    }

    public void setSender(User sender) {
        Sender = sender;
    }

    public int getTransfer_amount() {
        return Transfer_amount;
    }

    public void setTransfer_amount(int transfer_amount) {
        Transfer_amount = transfer_amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "Identifier=" + Identifier +
                ", Recipient=" + Recipient.getName() +
                ", Sender=" + Sender.getName() +
                ", Transfer_amount=" + Transfer_amount +
                ", tc=" + tc +
                '}';
    }
}
