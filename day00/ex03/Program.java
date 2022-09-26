import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        long count = 0;
        int weeks = 1;
        while (scan.hasNextLine())
        {
            String text = scan.nextLine();
            if (text.equals("42")) {
                break;
            }
            if (!text.equals("Week " + weeks)) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            int min = 9;
            int grade = 0;
            for (int i = 0; i < 5; i++) {
                if (!scan.hasNextInt()) {
                    System.err.println("IllegalArgument");
                    System.exit(-1);
                }
                grade = scan.nextInt();

                if (grade < 0 || grade > 9) {
                    System.err.println("IllegalArgument");
                    System.exit(-1);
                }
                if (min > grade)
                    min = grade;

            }
            long value = 1;

            if (weeks > 1)
                for (int i = 0; i < weeks - 1; i++)
                    value *= 10;
            value *= min;
            count += value;
            if (weeks < 18)
                weeks++;
            else
                break;
            scan.nextLine();
        }

        int i = 1;
        while (count > 0)
        {
            System.out.print("Week ");
            System.out.print(i);
            System.out.print(" ");
            int value = (int)(count % 10);
            for (int j = 0; j < value; j++) {
                System.out.print("=");
            }
            System.out.println(">");
            i++;
            count /=10;
        }

        scan.close();
    }
}
