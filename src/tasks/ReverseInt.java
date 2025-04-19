package tasks;

public class ReverseInt {

    public static int reverse(int x) {
        boolean isMinus = x < 0;
        var string = Integer.toString(Math.abs(x));
        var builder = new StringBuilder();
        if (isMinus) builder.append("-");
        for (var i = string.length(); i > 0; i--) {
            builder.append(string.charAt(i - 1));
        }
        try {
            return Integer.parseInt(builder.toString());
        } catch (NumberFormatException e) {
            System.out.println("Итоговое число вне диапозона INT : " + builder);
            return 0;
        }
    }


    public static void testReverse() {
        System.out.println(reverse(12345));
        System.out.println(reverse(-321));
        System.out.println(reverse(120));
        System.out.println(reverse(0));
        System.out.println(reverse(Integer.MAX_VALUE));
    }

}
