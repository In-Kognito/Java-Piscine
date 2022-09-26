public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException(String messenger) { super(messenger); }
}
