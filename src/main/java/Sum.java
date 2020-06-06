package main.java;

public class Sum implements Expression {
    public Money billOne;
    public Money billTwo;

    public Sum(Money billOne, Money billTwo) {
        this.billOne = billOne;
        this.billTwo = billTwo;
    }

    public Money reduce(String currency) {
        int amount = billOne.amount + billTwo.amount;
        return new Money(amount, currency);
    }
}
