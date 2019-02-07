package com.lexicon.zoo;

public class Flamingo extends Bird {

    private static final Animal.Species species = Species.FLAMINGO;

    public Flamingo() {}

    public Flamingo(int age, double weight, boolean sex, int wingsInCm, int neckInCm) {
        super(age, weight, sex);
        setWingsInCm(wingsInCm);
        setNeckInCm(neckInCm);
        setFlies(true); // alla flamingoer antas kunna flyga
    }

    @Override
    public Animal.Species getSpecies() { return species; }
}
