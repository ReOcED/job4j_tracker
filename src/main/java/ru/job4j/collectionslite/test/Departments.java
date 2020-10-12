package ru.job4j.collectionslite.test;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        HashSet<String> unique = new HashSet<>();
        for (String dep : deps) {
            StringBuilder starts = new StringBuilder();
            for (String s : dep.split("/")) {
                if (starts.length() != 0) {
                    starts.append("/");
                }
                starts.append(s);

                unique.add(starts.toString());
            }
        }
        List<String> rsl = new ArrayList<>(unique);
        rsl.sort(Comparator.naturalOrder());
//        rsl.sort(new DepDescComp());
        return rsl;
    }

    public static void main(String[] args) {
        for (String s : Departments.fillGaps(Arrays.asList("K1/SK1/SSK1", "K2/SK2/SSK1", "K2/SK1/SSK1", "K2/SK1/SSK2"))) {
            System.out.println(s);
        }
    }

    public static void sortAsc(List<String> orgs) {
    }

    public static void sortDesc(List<String> orgs) {
    }
}
