package tasks;

//Вам дано число, записанное римскими цифрами. Получите это же число в обычной записи (арабскими цифрами).
//        Римская запись чисел может включать следующие символы:
//
//        ’I’ — 1
//        ’V’ — 5
//        ’X’ — 10
//        ’L’ — 50
//        ’C’ — 100
//        ’D’ — 500
//        ’M’ — 1000
//        Цифры ’I’, ’X’, ’C’ и ’M’ нельзя использовать более трех раз подряд. Цифры ’V’, ’L’ и ’D’ нельзя использовать более одного раза во всей записи числа.
//        Обыкновенно цифры записывают по убыванию слева направо. Например, число 350 будет записано как ’CCCL’.
//        Однако есть исключения:
//
//        Чтобы получить ’4’ или ’9’, надо поставить ’I’ перед ’V’ или ’X’ соответственно
//        Чтобы получить ’40’ или ’90’, надо поставить ’X’ перед ’L’ или ’C’.
//        Чтобы получить ’400’ или ’900’, надо поставить ’C’ перед ’D’ или ’M’

public class RomanNumber {
    static int ICounter = 0;
    static int XCounter = 0;
    static int CCounter = 0;
    static int MCounter = 0;

    static boolean recordControl = true;

    public static int convertToArabic(String romanNumber) {
        if (romanNumber == null || romanNumber.length() == 0) return -1;

        int decimal = 0;
        int lastNumber = 0;
        int previousLastNumber = 0;
        String romanNumeral = romanNumber.toUpperCase();

        int VCounter = 0;
        int LCounter = 0;
        int DCounter = 0;

        for (int i = romanNumeral.length() - 1; i >= 0; i--) {
            char convertToDecimal = romanNumeral.charAt(i);

            switch (convertToDecimal) {
                case 'M' -> {
                    if (MCounter >= 3) recordControl = false;
                    decimal = processDecimal(1000, previousLastNumber, lastNumber, decimal);
                    previousLastNumber = lastNumber;
                    lastNumber = 1000;
                    MCounter++;
                    resetCounters(convertToDecimal);
                }
                case 'D' -> {
                    if (DCounter >= 1) recordControl = false;
                    decimal = processDecimal(500, previousLastNumber, lastNumber, decimal);
                    previousLastNumber = lastNumber;
                    lastNumber = 500;
                    DCounter++;
                    resetCounters(convertToDecimal);
                }
                case 'C' -> {
                    if (CCounter >= 3) recordControl = false;
                    decimal = processDecimal(100, previousLastNumber, lastNumber, decimal);
                    previousLastNumber = lastNumber;
                    lastNumber = 100;
                    CCounter++;
                    resetCounters(convertToDecimal);
                }
                case 'L' -> {
                    if (LCounter >= 1) recordControl = false;
                    decimal = processDecimal(50, previousLastNumber, lastNumber, decimal);
                    previousLastNumber = lastNumber;
                    lastNumber = 50;
                    LCounter++;
                    resetCounters(convertToDecimal);
                }
                case 'X' -> {
                    if (XCounter >= 3) recordControl = false;
                    decimal = processDecimal(10, previousLastNumber, lastNumber, decimal);
                    previousLastNumber = lastNumber;
                    lastNumber = 10;
                    XCounter++;
                    resetCounters(convertToDecimal);
                }
                case 'V' -> {
                    if (VCounter >= 1) recordControl = false;
                    decimal = processDecimal(5, previousLastNumber, lastNumber, decimal);
                    previousLastNumber = lastNumber;
                    lastNumber = 5;
                    VCounter++;
                    resetCounters(convertToDecimal);
                }
                case 'I' -> {
                    if (ICounter >= 3) recordControl = false;
                    decimal = processDecimal(1, previousLastNumber, lastNumber, decimal);
                    previousLastNumber = lastNumber;
                    lastNumber = 1;
                    ICounter++;
                    resetCounters(convertToDecimal);
                }
                default -> recordControl = false;
            }
            if (!recordControl) {
                resetCounters('0');
                recordControl = true;
                return -1;
            }
        }
        resetCounters('0');
        return decimal;
    }

    public static int processDecimal(int decimal, int previousLast, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal) {
            if (previousLast >= lastNumber) {
                recordControl = false;
            }
            switch (lastNumber) {
                case (5), (10) -> {
                    if (decimal != 1) {
                        recordControl = false;
                    }
                }
                case (50), (100) -> {
                    if (decimal != 10) {
                        recordControl = false;
                    }
                }
                case (500), (1000) -> {
                    if (decimal != 100) {
                        recordControl = false;
                    }
                }
                default -> recordControl = false;
            }
            return lastDecimal - decimal;
        } else {
            if (previousLast > decimal) {
                recordControl = false;
            }
            return lastDecimal + decimal;
        }
    }

    private static void resetCounters(char ch) {
        switch (ch) {
            case 'I' -> {
                XCounter = 0;
                CCounter = 0;
                MCounter = 0;
            }
            case 'X' -> {
                ICounter = 0;
                CCounter = 0;
                MCounter = 0;
            }
            case 'C' -> {
                ICounter = 0;
                XCounter = 0;
                MCounter = 0;
            }
            case 'M' -> {
                ICounter = 0;
                XCounter = 0;
                CCounter = 0;
            }
            default -> {
                ICounter = 0;
                XCounter = 0;
                CCounter = 0;
                MCounter = 0;
            }
        }
    }

    public static void romanConverterTests() {
        System.out.println(convertToArabic("I"));
        System.out.println(convertToArabic("V"));
        System.out.println(convertToArabic("IX"));
        System.out.println(convertToArabic("LVIII"));
        System.out.println(convertToArabic("MCMXCIV"));
        System.out.println(convertToArabic("CCCXL"));
        System.out.println(convertToArabic("DIV"));
        System.out.println(convertToArabic("MDCLXVI"));
        System.out.println();
        System.out.println(convertToArabic("Z"));
        System.out.println(convertToArabic("LUVI"));
        System.out.println(convertToArabic("VIDLII"));
        System.out.println(convertToArabic("XVVI"));
        System.out.println(convertToArabic("MCMMXCIV"));
        System.out.println(convertToArabic("CCCCXL"));
        System.out.println(convertToArabic("IIII"));
        System.out.println(convertToArabic("IIV"));
    }


}