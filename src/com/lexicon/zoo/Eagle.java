package com.lexicon.zoo;

public class Eagle extends Bird {

    private int numOfMice; // unik egenskap för Eagle

    private static final Animal.Species species = Species.EAGLE;

    public Eagle(){}

    public Eagle(int age, double weight, boolean sex, int wingsInCm, int numOfMice) {
        super(age, weight, sex);
        setWingsInCm(wingsInCm);
        setFlies(true); // alla örnar antas kunna flyga
        setNumOfMice(numOfMice);
    }

    public int getNumOfMice() {
        return numOfMice;
    }
    public void setNumOfMice(int numOfMice) throws IllegalArgumentException {
        try {
            if(numOfMice < 0) throw new IllegalArgumentException(getSpeciesName(Animal.DEFINITE) +
            " " + getName(true) + " antal möss måste ha ett positivt värde!");
        } catch (Exception e) { System.out.println(e.getMessage()); }
        this.numOfMice = numOfMice;
    }

    @Override
    public Animal.Species getSpecies() { return species; }

    @Override
    public String toString() {
        return(super.toString() + "äter:\t\t" + getNumOfMice() + " möss per dag\n");
    }
}
