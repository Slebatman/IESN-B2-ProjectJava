package test;

import business.DelayManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class DelayManagerTest {

    private DelayManager manager;

    @BeforeEach
    void setUp() {
        manager = new DelayManager();
    }

    @Test
    void diffDays() {
        GregorianCalendar startDateTest = new GregorianCalendar();
        GregorianCalendar endDateTest = new GregorianCalendar();

        startDateTest.set(GregorianCalendar.YEAR, 2021);
        startDateTest.set(GregorianCalendar.MONTH, 5);
        startDateTest.set(GregorianCalendar.DATE, 5);

        endDateTest.set(GregorianCalendar.YEAR, 2021);
        endDateTest.set(GregorianCalendar.MONTH, 5);
        endDateTest.set(GregorianCalendar.DATE, 15);

        assertEquals(10, manager.diffDays(endDateTest, startDateTest));
    }

    @Test
    void nbRecalls() {
        assertEquals(2, manager.nbRecalls(15));
    }
}