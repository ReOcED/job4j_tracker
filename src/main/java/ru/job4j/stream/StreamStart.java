package ru.job4j.stream;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamStart {


    public static void main(String[] args) {
        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );
//        matrix.stream().flatMap(Collection::stream).forEach(System.out::println);
        int row = 3;
        int col = 3;
        Integer[][] ms = new Integer[row][col];

/*        for (int i = 0; i < row; i++) {
            ms[i] = (Integer[]) ThreadLocalRandom.current().ints().limit(col).toArray();
        }
        for (int[] z : ms) {
            for (int i : z) {
                System.out.print(i + "    ");
            }
            System.out.println("");
        }

 */
        List<Integer> collection = Arrays.stream(ms).flatMap(Arrays::stream).collect(Collectors.toList());

//        List<Integer> integers =
//                Arrays.stream(ms).flatMap(x -> Arrays.stream(x));
//        Arrays.stream(ms).forEach(x -> Arrays.stream(x).forEach(System.out::println));



    }
}
