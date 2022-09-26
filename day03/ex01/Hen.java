public class Hen extends Thread {
    int count = 0;

    public Hen(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int j = 0; j < count; j++) {
            Program.printHen();
        }

    }
}