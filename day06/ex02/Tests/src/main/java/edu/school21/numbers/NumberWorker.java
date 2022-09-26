package edu.school21.numbers;

class NumberWorker {
    public boolean isPrime(int number) {
        int count = 0;
        int i = 2;
        if (number <= 1) {
            throw new IllegalNumberException("Illegal argument");
        }
        if (number == 2 || number == 3) {
            return true;
        }
        int res = 0;
        while (res < number) {
            res = i * i;
            count++;
            if (number % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public int digitsSum(int number) {

        int result = 0;
        while (number > 0) {
            result += number % 10;
            number /= 10;
        }

        return (result);
    }



}

class IllegalNumberException extends RuntimeException {
    public IllegalNumberException(String messange) {
        super(messange);
    }
}
