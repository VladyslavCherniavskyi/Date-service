package com.sample;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Component
public class DateSorter {

    private static final String LETTER = "r";

    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        return Stream.of(
                        unsortedDates.stream()
                                .filter(date -> contains(date.getMonth()))
                                .sorted(Comparator.naturalOrder())
                                .toList(),
                        unsortedDates.stream()
                                .filter(date -> !contains(date.getMonth()))
                                .sorted(Comparator.reverseOrder())
                                .toList()
                )
                .flatMap(List::stream)
                .toList();
    }

    private boolean contains(Month month) {
        return month.name()
                .toLowerCase()
                .contains(LETTER);
    }

}
