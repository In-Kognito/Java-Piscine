public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String messenger) {
        super(messenger);
    }
}
