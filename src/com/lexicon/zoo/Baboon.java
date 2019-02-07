package com.lexicon.zoo;

public class Baboon extends Primate {

    private int caloriesPerDay; // unik egenskap för Baboon

    private static final Animal.Species species = Animal.Species.BABOON;

    public Baboon() {}

    public Baboon(int age, boolean sex, double weight, boolean tail, int caloriesPerDay) {
        super(age, weight, sex, tail);
        setCaloriesPerDay(caloriesPerDay);
    }

    // caloriesPerDay
    public int getCaloriesPerDay() { return caloriesPerDay; }
    public void setCaloriesPerDay(int caloriesPerDay) throws IllegalArgumentException {
        try {
            if (caloriesPerDay < 0)
                throw new IllegalArgumentException(getSpeciesName(DEFINITE) +
                        " " + getName() + " måste äta minst 1 kcal per dag!");
            this.caloriesPerDay = caloriesPerDay;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Animal.Species getSpecies() { return species; }

    @Override
    public String toString() {
        return (super.toString() + "äter:\t\t" + getCaloriesPerDay() + " kalorier per dag\n");
    }
}
