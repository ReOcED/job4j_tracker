package ru.job4j.collectionslite.search;

import ru.job4j.collectionslite.search.Person;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подошедщих пользователей.
     */

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person p : persons) {
            if (p.getPhone().contains(key) || p.getName().contains(key) || p.getAddress().contains(key) || p.getSurname().contains(key)) {
                result.add(p);
            }
        }
        return result;
    }
}
