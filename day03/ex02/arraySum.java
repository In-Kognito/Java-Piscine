public class arraySum extends Thread {
    private int size;
    private int first;


    public arraySum(int first, int size) {
        this.size = size;
        this.first = first;
    }

    @Override
    public void run() {
        int summa = 0;
        int start = first;
        for (; first < size; ++first)
        {
          summa += Program.array[first];

        }
        Program.maxSum += summa;
//        Program.setLast(size - 1);
//        for (; Program.getFirst() < Program.getLast() ; Program.setFirst(Program.getFirst() + 1)) {
//            summa += Program.array[Program.getFirst()];
//        }

        System.out.println(this.getName() + ": from " + start + " to " + (size - 1) + " sum is " + summa);

    }

}