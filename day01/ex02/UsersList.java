public interface UsersList {
    void addUser(String name, Integer balance);
    User getById(Integer number);
    User getByIndex(Integer number);
    int getNumberOfUsers();
}
