package com.lexicon.zoo;

public abstract class Primate extends Animal {
    private boolean tail; // unik egenskap för primater

    protected Primate() {}

    protected Primate(int age, double weight, boolean sex) {
        super(age, weight,sex);
    }

    protected Primate(int age, double weight, boolean sex, boolean tail) {
        this(age, weight,sex);
        setTail(tail);
    }

    public boolean hasTail() {
        return tail;
    }
    public void setTail(boolean tail) { this.tail = tail; }

    public String toString() {
        return(super.toString() + "svans:\t\t" + (hasTail() ? "ja\n" : "nej\n"));
    }
}
