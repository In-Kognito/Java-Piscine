public class Program {
    public static void main(String[] args) {
        UsersList Uzeri = new UsersArrayList();
        Uzeri.addUser("Oleg", 20000);
        Uzeri.addUser("Gleb", 700);
        Uzeri.addUser("Olga", 3000);
        Uzeri.addUser("Vita", 5000);
        Uzeri.addUser("Vitya", 800);
        Uzeri.addUser("Vasya", 1000);
        Uzeri.addUser("Sveta", 2100);
        Uzeri.addUser("Dima", 1100);
        Uzeri.addUser("Eva", 5000);
        Uzeri.addUser("Adam", 5500);
        Uzeri.addUser("Diana", 7500);
        Uzeri.addUser("Mama", 50000);
        Uzeri.addUser("Wife", 1000);

        try {
            System.out.println(Uzeri.getById(12));
            System.out.println(Uzeri.getByIndex(1));
            System.out.println(Uzeri.getById(50));
        }
        catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Size - " + Uzeri.getNumberOfUsers());


    }
}
