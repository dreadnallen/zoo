package com.lexicon.zoo;

public class Chimpanzee extends Primate {

    private int numOfBananas; // unik egenskap för Chimpanzee

    private static final Animal.Species species = Animal.Species.CHIMPANZEE;

    public Chimpanzee(int age, double weight, boolean sex, boolean tail, int numOfBananas){
        super(age, weight, sex, tail);
        setNumOfBananas(numOfBananas);
    }

    // numOfBananas
    public int getNumOfBananas() { return numOfBananas; }
    public void setNumOfBananas(int numOfBananas) throws IllegalArgumentException {
        try {
            if (numOfBananas < 0) throw new IllegalArgumentException(getSpeciesName(DEFINITE) +
                    " " + getName() + " måste äta minst en banan per dag!");
            this.numOfBananas = numOfBananas;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Animal.Species getSpecies() { return species; }

    @Override
    public String toString() {
        return (super.toString() + "äter:\t\t" + getNumOfBananas() + " bananer per dag\n");
    }
}
