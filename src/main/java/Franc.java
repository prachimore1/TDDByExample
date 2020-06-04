package main.java;

public class Franc {
    private int amount;

    public Franc(int amount) {
        this.amount = amount;
    }

    public Franc times(int multiplier) {
        return new Franc(this.amount * multiplier);
    }

    public boolean equals(Object o) {
        Franc franc = (Franc) o;
        return this.amount == franc.amount;
    }
}
