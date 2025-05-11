package tasks;

/*You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.

Given the integer n, return the number of complete rows of the staircase you will build.*/

public class ArrangingCoins {

    public static int arrangingCoins(int coins) {
        var remCoins = coins;
        var rows = 0;

        while (remCoins > 0) {
            remCoins = remCoins - (rows + 1);
            if (remCoins >= 0) {
                rows++;
            }
        }

        return rows;
    }

    public static void testsArrangingCoins() {
        System.out.println("3 -> " + arrangingCoins(6));
        System.out.println("0 -> " + arrangingCoins(0));
        System.out.println("5 -> " + arrangingCoins(16));
        System.out.println("2 -> " + arrangingCoins(5));
        System.out.println("0 -> " + arrangingCoins(-10));
    }


}
