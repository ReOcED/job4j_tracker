package ru.job4j.stream.turist;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .distinct()
                .sorted(Comparator.comparing(Address::getCity)
                        .thenComparing(Address::getStreet))
                .collect(Collectors.toList());
    }
}
