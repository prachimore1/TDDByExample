package test;

import main.java.Dollar;
import main.java.Franc;
import main.java.Money;
import main.java.Sum;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MultiplicationTest {
    @Test
    public void testDollarMultiplication() {
        Money five = new Dollar(5, "USD");
        assertEquals(new Dollar(10, "USD"), five.times(2));
        assertEquals(new Dollar(15, "USD"), five.times(3));
    }

    @Test
    public void testFrancMultiplication() {
        Money five = new Franc(5, "CHF");
        assertEquals(new Franc(10, "CHF"), five.times(2));
        assertEquals(new Franc(15, "CHF"), five.times(3));
    }

    @Test
    public void testEquality() {
        assertTrue(new Dollar(5, "USD").equals(new Dollar(5, "USD")));
        assertFalse(new Dollar(5, "USD").equals(new Dollar(6, "USD")));
        assertTrue(new Franc(5, "CHF").equals(new Franc(5, "CHF")));
        assertFalse(new Franc(5, "CHF").equals(new Franc(6, "CHF")));
        assertFalse(new Franc(5, "CHF").equals(new Dollar(5, "USD")));
    }

    @Test
    public void testCurrency() {
        assertEquals("USD", new Dollar(1, "USD").currency());
        assertEquals("CHF", new Franc(1, "CHF").currency());
    }

    @Test
    public void testDifferentClassEquality() {
        assertTrue(new Money(10, "CHF").equals(new Franc(10, "CHF")));
        assertFalse(new Money(10, "USD").equals(new Franc(10, "CHF")));
    }

    @Test
    public void testSimpleAddition() {
        final Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    public void testPlusReturnsSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.billOne);
        assertEquals(five, sum.billTwo);
    }

    @Test
    public void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    @Test
    public void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }
}
