package ru.job4j.stream;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cards {

    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        V_6, V_7, V_8
    }

    private Suit suit;
    private Value value;

    public Cards(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Cards{" + "suit=" + ", value=" + suit.name() + value.name() + '}';
    }

    public static void main(String[] args) {

        List<Cards> c = Arrays.stream(Suit.values())
                .flatMap(suit -> Arrays.stream(Value.values())
                        .map(value -> new Cards(suit, value)))
                        .collect(Collectors.toList());

    }
}