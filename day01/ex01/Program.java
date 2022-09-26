public class Program {
    public static void main(String[] args) {
        User us1 = new User("Oleg", 20000);
        System.out.println(us1.getIdentifier());
        User us2 = new User("Gleb", 700);
        System.out.println(us2.getIdentifier());
        User us3 = new User("Vitya", 4030§);
        System.out.println(us3.getIdentifier());
    }

}
