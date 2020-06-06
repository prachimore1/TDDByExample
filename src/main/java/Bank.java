package main.java;

import java.util.Hashtable;

public class Bank {
    private Hashtable rates = new Hashtable();

    public Money reduce(Expression source, String currency) {
        return source.reduce(this, currency);
    }

    public void addRate(String from, String to, int divideBy) {
        rates.put(new Pair(from, to), new Integer(divideBy));
    }

    public int getRate(String from, String to) {
        if (from.equals(to))
            return 1;
        Integer rate = (Integer) rates.get(new Pair(from, to));
        return rate.intValue();
    }
}
