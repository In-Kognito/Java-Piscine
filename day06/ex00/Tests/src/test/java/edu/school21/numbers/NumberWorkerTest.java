package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {

    NumberWorker numberWorker;

    @BeforeEach
    void init()
    {
        numberWorker = new NumberWorker();
    }

    @ParameterizedTest
    @ValueSource (ints = {3, 7, 11, 113})
    void isPrimeForPrimes(int arguments) {
        Assertions.assertTrue(numberWorker.isPrime(arguments));
    }

    @ParameterizedTest
    @ValueSource (ints = {4, 15, 169, 236})
    void isPrimeForNotPrimes(int arguments) {
        Assertions.assertFalse(numberWorker.isPrime(arguments));
    }

    @ParameterizedTest
    @ValueSource (ints = { -1, 0, 1, -1000})
    void isPrimeForIncorrectNumbers(int arguments) {
        Assertions.assertThrows(IllegalNumberException.class, () -> {
            numberWorker.isPrime(arguments);
        });
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", delimiter = ',')
    public void digitsSumTest1(int input, int summa) {
        Assertions.assertEquals(summa, numberWorker.digitsSum(input));
    }
}