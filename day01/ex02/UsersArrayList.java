public class UsersArrayList implements UsersList {
    private int capacity = 10;
    private User[] ArrayList = new User[capacity];

    @Override
    public void addUser(String name, Integer balance) {
        int i;
        for (i = 0; i < getNumberOfUsers(); i++) {
            continue;
        }
        if (i == capacity) {
            int new_capacity = capacity + capacity/2;
            User[] new_array = new User[new_capacity];
            for (int j = 0; j < capacity; j++) {
                new_array[j] = ArrayList[j];
            }
            capacity = new_capacity;
            ArrayList = new_array;
        }
        for (i = 0; ArrayList[i] != null; i++) {
            continue;
        }
        ArrayList[i] = new User(name, balance);

    }

    @Override
    public User getById(Integer number) throws UserNotFoundException {
        for (int i = 0; i != getNumberOfUsers(); i++) {
            if(number == ArrayList[i].getIdentifier())
                return ArrayList[i];
        }
        throw new UserNotFoundException("Id did not find");
    }

    @Override
    public User getByIndex(Integer number) throws UserNotFoundException {
        for (int i = 0; i != getNumberOfUsers(); i++) {
            if(number == i)
                return ArrayList[i];
        }
        throw new UserNotFoundException("Index did not find");
    }

    @Override
    public int getNumberOfUsers() {
        int i;
        for (i = 0; i < capacity; i++) {
            if (ArrayList[i] == null) {
                return i;
            }
        }

        return i;
    }
}
