public class Program {
    public static void main(String[] args) {

        User us1 = new User(1, "Oleg", 20000);
        User us2 = new User(1, "Gleb", 700);

        Transaction N1 = new Transaction(us2, us1, 500);

        System.out.println(N1);
    }
}
