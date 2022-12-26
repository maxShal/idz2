package org.example;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.GregorianCalendar;


public class FinanceReportProcessorTest {
    FinanceReport financeReport = new FinanceReport("Sergey", new GregorianCalendar(2021, 2, 10),
            new Payment("Pyaterochka", 100.2, new GregorianCalendar(2010, 2, 20)),
            new Payment("Magnit", 99.99, new GregorianCalendar(2019, 3, 2)),
            new Payment("Perekrestok", 1.2, new GregorianCalendar(2020, 12, 1)));

    @Test
    public void testFilterByPrefix() {
        FinanceReport result1 = FinanceReportProcessor.getReport(financeReport, "P");
        assertEquals(result1.getArr().length, 2);
        FinanceReport result2 = FinanceReportProcessor.getReport(financeReport, "xxxxx");
        assertEquals(result2.getArr().length, 0);
    }

    @Test
    public void testFilterByLimit() {
        FinanceReport result = FinanceReportProcessor.getPayment(financeReport, 10);
        assertEquals(result.getArr().length, 1);
    }
}