package com.lexicon.zoo;

public abstract class Bird extends Animal {
    private boolean flies;
    private int wingsInCm;
    private int neckInCm;

    protected Bird() {}

    protected Bird(int age, double weight, boolean sex) {
        super(age, weight, sex);
    }

    // flies
    public boolean isFlies() {
        return flies;
    }
    public void setFlies(boolean flies) {
        this.flies = flies;
    }

    // wingsInCm
    public int getWingsInCm() {
        return wingsInCm;
    }
    public void setWingsInCm(int wingsInCm) throws IllegalArgumentException {
        try {
            if (wingsInCm < 0)
                throw new IllegalArgumentException(getSpeciesName(DEFINITE) +
                        " " + getName(true) + " vingar måste vara minst 1 cm långa!");
            this.wingsInCm = wingsInCm;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // neckInCm
    public int getNeckInCm() {
        return neckInCm;
    }
    public void setNeckInCm(int neckInCm) throws IllegalArgumentException {
        try {
            if (neckInCm < 0)
                throw new IllegalArgumentException(getSpeciesName(DEFINITE) +
                        " " + getName(true) + " hals måste vara minst 1 cm lång!");
            this.neckInCm = neckInCm;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return (super.toString() + "flyger:\t\t" + (isFlies() ? "ja\n" : "nej\n") +
                (getWingsInCm()>0 ? "vingspann:\t" + getWingsInCm() + " cm\n" : "") +
                (getNeckInCm()>0 ? "hals:\t\t" + getNeckInCm() + " cm\n" : ""));
    }
}
