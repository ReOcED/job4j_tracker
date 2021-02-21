package ru.job4j.lambda;

import org.junit.Test;
import ru.job4j.collectionslite.search.Person;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("534872");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }
}

