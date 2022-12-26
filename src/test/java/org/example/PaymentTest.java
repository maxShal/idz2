package org.example;
import org.junit.Test;

import java.util.GregorianCalendar;

public class PaymentTest {
    @Test(expected = IllegalArgumentException.class)
    public void testSumInvalid() {
        Payment payment = new Payment("name", -42.0, new GregorianCalendar());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNameInvalid() {
        Payment payment = new Payment(null, 100.0, new GregorianCalendar());
    }
}