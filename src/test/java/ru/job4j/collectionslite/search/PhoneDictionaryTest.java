package ru.job4j.collectionslite.search;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertEquals(persons.get(0).getSurname(), "Arsentev");
    }
}