package com.sample;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DateSorterTest {

    private final List<LocalDate> UNSORTED_DATES = Arrays.asList(
            LocalDate.of(2004, 7, 1),
            LocalDate.of(2005, 1, 2),
            LocalDate.of(2007, 1, 1),
            LocalDate.of(2032, 5, 3)
    );

    @Test
    public void testSortDates() {
        //given
        var dateSorter = new DateSorter();
        var expectedDates = Arrays.asList(
                LocalDate.of(2005, 1, 2),
                LocalDate.of(2007, 1, 1),
                LocalDate.of(2032, 5, 3),
                LocalDate.of(2004, 7, 1)
        );

        //when
        var actualDates = dateSorter.sortDates(UNSORTED_DATES);

        //then
        assertEquals(expectedDates, actualDates);
    }

}