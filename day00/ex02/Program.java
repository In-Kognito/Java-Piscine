import java.util.Scanner;

public class Program {

    static int ex00(long num) {
        int result = 0;

        while (num > 0)
        {
            result += num % 10;
            num /= 10;
        }

        return ((int)result);
    }

    static boolean ex01(int num)
    {
        int count = 0;
        int i = 2;

        int res = 0;
        while (res < num) {
            res = i * i;
            count++;
            if (num % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long num;
        int count = 0;
        while (scan.hasNextLong())
        {
            num = scan.nextLong();
            if (num == 42)
                break ;

            num = ex00(num);
            if (num < 2)
                continue;
            else
                if (ex01((int)num))
                    count++;
        }
        System.out.println("Count of coffee-request - " + count);
        scan.close();
    }
}
