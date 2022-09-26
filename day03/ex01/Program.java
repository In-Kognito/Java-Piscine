import java.lang.Thread;

public class Program{
    private static Integer count;
    private static Boolean flag = true;

    public static synchronized void printEgg() {
        if (!flag) {
            try {
                Program.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Egg");
        flag = false;
        Program.class.notify();
    }

    public static synchronized void printHen() {
        if (flag) {
            try {
                Program.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hen");
        flag = true;
        Program.class.notify();
    }

    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1) {
            System.err.println("Wrong numbers of arguments");
            System.exit(-1);
        }
        String countStr = args[0];
        if (args[0].startsWith("--count=")) {
            countStr = args[0].substring(8);
        }
        if (countStr.length() == 0) {
            System.err.println("Wrong numbers of count");
            System.exit(-1);
        }
        count = Integer.parseInt(countStr);
        Thread egg = new Egg(count);
        Thread hen = new Hen(count);
        egg.start();
        hen.start();

        try {
            hen.join();
            egg.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}