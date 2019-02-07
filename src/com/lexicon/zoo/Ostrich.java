package com.lexicon.zoo;

public class Ostrich extends Bird {

    private static final Animal.Species species = Species.OSTRICH;

    public Ostrich(){}

    public Ostrich(int age, double weight, boolean sex) {
        super(age, weight, sex);
    }

    public Ostrich(int age, double weight, boolean sex, int wingsInCm, int maxSpeed) {
        this(age, weight, sex);
        setMaxSpeed(maxSpeed);
        setWingsInCm(wingsInCm);
        setFlies(false); // inga strutsar antas kunna flyga
    }

    @Override
    public Animal.Species getSpecies() { return species; }
}
