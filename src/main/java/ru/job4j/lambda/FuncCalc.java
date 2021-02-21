package ru.job4j.lambda;

import java.util.*;
import java.util.function.*;

public class FuncCalc {

    public static List<Double> diapason(double start, double end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        while (start < end) {
            result.add(func.apply(start++));
        }
        return result;
    }




}
