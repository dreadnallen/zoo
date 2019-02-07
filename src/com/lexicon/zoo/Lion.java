package com.lexicon.zoo;

public class Lion extends Animal implements Predator {

    private final Animal.Species species = Species.LION;

    Lion(int age, double weight, boolean sex) {
        super(age, weight, sex);
    }

    Lion(int age, double weight, boolean sex, int maxSpeed) {
        this(age, weight, sex);
        setMaxSpeed(maxSpeed);
    }

    public int attack(Animal a) {
        double predatorForce = getWeight() / (a.getWeight() + 1); // rovdjurets förmåga att skada bytet
        double preyForce = (double) a.getMaxSpeed() / (double) (getMaxSpeed() + 1); // bytets förmåga att skada rovdjuret

        int attack = (int) (predatorForce * (Math.random() * 50 + 1));
        int wound = (int) (preyForce * (Math.random() * 50 + 1));

        a.decreaseHealth(attack); // minska bytets hälsa
        decreaseHealth(wound);  // minska rovdjurets hälsa

        System.out.println();
        System.out.println(getSpeciesName(Animal.DEFINITE) + " " + getName() +
                " attackerar " + a.getSpeciesName(Animal.DEFINITE).toLowerCase() + " " +
                a.getName() + " (-"  + attack + " hp).");
        System.out.println(getSpeciesName(Animal.DEFINITE) + " " + getName() +
                " skadas av " + a.getSpeciesName(Animal.DEFINITE).toLowerCase() + " " +
                a.getName() + " (-" + wound + " hp).");

//        System.out.println("styrkeförhållande: " + predatorForce / preyForce);

        return (getHealth());
    }

    @Override
    public Animal.Species getSpecies() { return species; }
}
