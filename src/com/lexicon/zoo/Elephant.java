package com.lexicon.zoo;

public class Elephant extends Animal {

    private boolean tail;
    private int trunkLengthCm;

    private static final Animal.Species species = Species.ELEPHANT;

    public Elephant(){}

    public Elephant(int age, double weight, boolean sex) {
        super(age, weight, sex);
    }

    public Elephant(int age, double weight, boolean sex, boolean tail, int trunkLengthCm) {
        this(age, weight, sex);
        setSex(sex);
        setTail(tail);
        setTrunkLengthCm(trunkLengthCm);
    }

    public boolean hasTail() {
        return tail;
    }
    public void setTail(boolean tail) {
        this.tail = tail;
    }

    public int getTrunkLengthCm() {
        return trunkLengthCm;
    }
    public void setTrunkLengthCm(int trunkLengthCm) {
        this.trunkLengthCm = trunkLengthCm;
    }

    @Override
    public Animal.Species getSpecies() { return species; }

    @Override
    public String toString() {
        return(super.toString() + "svans:\t\t" + (hasTail() ? "ja\n" : "nej\n") +
                "snabel:\t\t" + getTrunkLengthCm() + " cm lång\n");
    }
}
