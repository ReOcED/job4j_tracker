package ru.job4j.collectionslite.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        List<String> deps1 = Arrays.asList(o1.split("/"));
        List<String> deps2 = Arrays.asList(o2.split("/"));
        int rsl = deps2.get(0).compareTo(deps1.get(0));
        int i = 1;
        while (rsl == 0 && i < deps1.size() && i < deps2.size() ) {
            rsl = deps1.get(i).compareTo(deps2.get(i));
            i++;
        }

        if (rsl == 0 && deps1.size() != deps2.size()) {
            rsl = deps2.size() > deps1.size() ? -1 : 1;
        }

        return rsl;
    }
}
