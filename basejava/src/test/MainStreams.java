package test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainStreams {
    public static void main(String[] args) {

        int[] values1 = new int[]{3, 3, 2, 3, 1, 2};
        int[] values2 = new int[]{9, 8};

        List<Integer> integers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> integers2 = Arrays.asList(2, 3, 4, 5, 6);

        System.out.println("Print minValues from arrays");
        System.out.println(minValue(values1));
        System.out.println(minValue(values2));

        System.out.println("Print list with odd sum");
        printList(oddOrEven(integers1));

        System.out.println("Print list with even sum");
        printList(oddOrEven(integers2));
    }

    private static int minValue(int[] values) {
        int num = Arrays.stream(values)
                .distinct()
                .sorted()
                .reduce((acc, x) -> (acc * 10) + x)
                .getAsInt();
        return num;
    }

    private static List<Integer> oddOrEven(List<Integer> integers) {
        return integers.stream()
                .filter(integers.stream().mapToInt(Integer::intValue)
                        .sum() % 2 != 0 ? x -> x % 2 == 0 : x -> x % 2 != 0)
                .collect(Collectors.toList());
    }

    private static void printList(List<Integer> integers) {
        for (int num : integers) {
            System.out.println(num);
        }
    }
}
