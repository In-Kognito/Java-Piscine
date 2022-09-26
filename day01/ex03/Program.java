public class Program {
    public static void main(String[] args) {

        User us1 = new User(1, "Oleg", 20000);
        User us2 = new User(1, "Gleb", 700);

        Transaction N1 = new Transaction(us2, us1, 500);
        Transaction N2 = new Transaction(us2, us1, 1000);
        Transaction N3 = new Transaction(us2, us1, 800);

        System.out.println("Create trList");
        TransactionsLinkedList trList = new TransactionsLinkedList();
        trList.addTransaction(N1);
        trList.addTransaction(N2);
        trList.addTransaction(N3);

        System.out.println("Delete Transaction");
        trList.rmTransactionById(N2.getIdentifier());

        Transaction[] array = trList.TransformToArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].toString());
        }





    }
}
