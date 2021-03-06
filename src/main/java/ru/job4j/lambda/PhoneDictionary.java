package ru.job4j.lambda;

import ru.job4j.collectionslite.search.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {

        Predicate<Person> byName = (x) -> x.getName().contains(key);
        Predicate<Person> bySurname = (x) -> x.getSurname().contains(key);
        Predicate<Person> byPhone = (x) -> x.getPhone().contains(key);
        Predicate<Person> combine = byName.or(bySurname).or(byPhone);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
