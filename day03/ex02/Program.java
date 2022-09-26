public class Program {
    static int forAll = 0;
    static int lastPart = 0;
    static int[] array;
    static int first = 0;
    static int last = 0;
    static int maxSum = 0;

    public static void calculatePartOfArray(int size, int count) {
        if ( (size % count) != 0) {
            int a = count - 1;
            forAll = (size/a) - 1;
            int b = forAll * a;
            lastPart = size - b;
        }
        else {
            forAll = size / count;
            int a = count * forAll;
            lastPart = size - a;
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Wrong numbers of arguments");
            System.exit(-1);
        }
        String sizeStr = args[0];
        if (args[0].startsWith("--arraySize=")) {
            sizeStr = args[0].substring(12);
        }
        if (sizeStr.length() == 0) {
            System.err.println("Wrong Size");
            System.exit(-1);
        }
        int arraySize = Integer.parseInt(sizeStr);

        String threadsStr = args[1];
        if (args[1].startsWith("--threadsCount=")) {
            threadsStr = args[1].substring(15);
        }
        if (threadsStr.length() == 0) {
            System.err.println("Wrong Threads");
            System.exit(-2);
        }
        int threadsCount = Integer.parseInt(threadsStr);

        if (arraySize < threadsCount) {
            System.err.println("Threads can't be greater than size of array");
            System.exit(-3);
        }
        array = new int[arraySize];
        int sumOfarray = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 1000);
            sumOfarray += array[i];
        }
        System.out.println("Sum: " + sumOfarray);

        calculatePartOfArray(arraySize, threadsCount);
        Thread[] arrayThread = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            arraySize -= forAll;
            if (arraySize >= lastPart) {
                arrayThread[i] = new arraySum(last += first, last += forAll);
            }
            else
                arrayThread[i] = new arraySum(last += first, last += lastPart);
            arrayThread[i].start();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Sum by threads: " + maxSum);

    }
}

