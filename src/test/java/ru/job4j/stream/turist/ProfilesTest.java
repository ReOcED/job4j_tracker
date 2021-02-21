package ru.job4j.stream.turist;

import org.junit.Test;
import ru.job4j.stream.studfilter.Student;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenProfilesGetAdresses() {
        Address add1 = new Address("city1", "street1", 1, 1);
        Address add2 = new Address("city1", "street1", 1, 1);
        Address add3 = new Address("city2", "street2", 1, 1);
        Address add4 = new Address("city1", "street1", 2, 1);
        List<Profile> profiles = List.of(
                new Profile(add1),
                new Profile(add2),
                new Profile(add3),
                new Profile(add4)
        );
        Profiles prof = new Profiles();
        List<Address> rsl = prof.collect(profiles);
        List<Address> expected = List.of(add1, add4, add3);
        assertThat(rsl, is(expected));

    }

}