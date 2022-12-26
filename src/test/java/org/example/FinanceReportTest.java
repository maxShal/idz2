package org.example;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.GregorianCalendar;


public class FinanceReportTest {
    FinanceReport financeReport = new FinanceReport("Sergey", new GregorianCalendar(2021, 2, 10),
            new Payment("Pyaterochka", 100.2, new GregorianCalendar(2010, 2, 20)),
            new Payment("Magnit", 99.99, new GregorianCalendar(2019, 5, 2)),
            new Payment("Perekrestok", 1.2, new GregorianCalendar(2020, 12, 1)));

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndex() {
        financeReport.getPayment(financeReport.getArr().length + 100);
    }

    @Test
    public void testCopy() {
        FinanceReport copy = new FinanceReport(financeReport);
        copy.setPayment(0, new Payment("name", 10.1, new GregorianCalendar()));
        assertNotEquals(copy.getPayment(0), financeReport.getPayment(0));
    }
}