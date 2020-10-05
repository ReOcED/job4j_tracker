package ru.job4j.collectionslite.search;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : array) {
            for (int i : row) {
                list.add(i);
            }
        }
        return list;
    }
}