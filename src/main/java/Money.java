package main.java;

public abstract class Money {
    protected int amount;
    protected String currency;

    public static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return (this.amount == money.amount)
                && getClass().equals(money.getClass());
    }

    public abstract Money times(int multiplier);

    public String currency() {
        return currency;
    }
}
