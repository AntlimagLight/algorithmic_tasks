package tasks;

public class FibonacciNumber {
    //найти n-е число фибоначчи

    public static int findFibonacciNumber(int n) {
        if (n <= 1) {
            return n;
        }
        int previous = 1;
        int beforePrevious = 0;
        int result = 0;
        for (int i = 1; i < n; i++) {
            result = previous + beforePrevious;
            beforePrevious = previous;
            previous = result;
        }
        return result;
    }

    public static void startTestsFibonacciNumber() {
        System.out.println(findFibonacciNumber(0));
        System.out.println(findFibonacciNumber(1));
        System.out.println(findFibonacciNumber(2));
        System.out.println(findFibonacciNumber(3));
        System.out.println(findFibonacciNumber(4));
        System.out.println(findFibonacciNumber(5));
        System.out.println(findFibonacciNumber(6));
        System.out.println(findFibonacciNumber(7));
        System.out.println(findFibonacciNumber(10));
        System.out.println(findFibonacciNumber(25));
    }
}
