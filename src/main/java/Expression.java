package main.java;

public interface Expression {
    Money reduce(Bank bank, String to);
}
