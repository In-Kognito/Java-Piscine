import java.lang.Thread;

public class Program {
    private static Integer count;

    public static class Egg extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < count ; i++) {
                System.out.println("Egg");
            }
        }
    }
    public static class Hen extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < count ; i++) {
                System.out.println("Hen");
            }
        }
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
        Thread egg = new Egg();
        Thread hen = new Hen();
        egg.start();
        hen.start();

        try {
            hen.join();
            egg.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < count; i++) {
            System.out.println("Human");
        }

    }
}
