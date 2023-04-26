package tasks;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CardCounter {
    private static List<Integer> zip(List<Integer> a, List<Integer> b) {
        List<Integer> out = new ArrayList<>();
        int turns = a.get(0);
        out.add(turn(b,0,turns));
        return out;
    }

    private static int turn(List<Integer> cards, int currentScore, int turns) {
        if (turns == 0) {
            return currentScore;
        }
        int leftPick = cards.get(0);
        int rightPick = cards.get(cards.size() - 1);
        List<Integer> newRow = new ArrayList<>(cards);
        newRow.remove(leftPick < rightPick ? cards.size() -1 : 0);
        return Math.max(turn(newRow, currentScore + leftPick, turns - 1),
                turn(newRow, currentScore + rightPick, turns - 1));
        // TODO Не работает. Отложено.
    }


    public static void run() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine());
            List<Integer> a = readList(reader);
            List<Integer> b = readList(reader);
            printList(zip(a, b), writer);
        }
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static <T> void printList(List<T> list, Writer writer) {
        list.forEach(elem -> {
                    try {
                        writer.write(String.valueOf(elem));
                        writer.write(" ");
                    } catch (IOException ignored) {

                    }
                }
        );
    }
}
