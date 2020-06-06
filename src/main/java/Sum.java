package main.java;

public class Sum implements Expression {
    public Expression billOne;
    public Expression billTwo;

    public Sum(Expression billOne, Expression billTwo) {
        this.billOne = billOne;
        this.billTwo = billTwo;
    }

    public Money reduce(Bank bank, String to) {

        int amount = billOne.reduce(bank, to).amount
                + billTwo.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    public Expression times(int multiplier) {
        return new Sum(billOne.times(multiplier), billTwo.times(multiplier));
    }
}
