package com.lexicon.zoo;

import java.util.ArrayList;
import java.util.Iterator;

public class Zoo {

    ArrayList<Animal> animals = new ArrayList<>();
    private int balance;

    Zoo(int funds, Animal... animals) {
        setBalance(funds);
        for (Animal a : animals) { addAnimal(a); }
        System.out.println("Ett zoo har skapats med " +
                getNumberOfAnimals() + " st djur och " +
                getBalance() + " USD i kassan." );
    }

    // lägga till och ta bort djur
    public void addAnimal(Animal a) { animals.add(a); }
    public void removeAnimal(Animal a) { animals.remove(a); }

    public int getNumberOfAnimals() { return animals.size();}

    // balance
    public void setBalance(int balance) throws IllegalArgumentException {
        try {
            if (balance < 0)
                throw new IllegalArgumentException("Zooets tillgångar måste tilldelas ett positivt värde!");
            this.balance = balance;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getBalance() { return balance; }

    public void addFunds(int funds) { balance += funds; }
    public boolean subtractFunds(int funds) {
        if (funds <= balance) {
            balance -= funds;
            return true;
        } else {
            return false;
        }
    }

    // köpa och sälja djur
    public boolean buyAnimal(Animal a) {
        if(a != null && subtractFunds(a.getPrice())) {
            addAnimal(a);
            System.out.println("Köpte " +
                    a.getSpeciesName(Animal.DEFINITE).toLowerCase() + " " +
                    a.getName() + " för " + a.getPrice() + " USD.");
            return true;
        }
        System.out.println("Köp av " +
                a.getSpeciesName(Animal.DEFINITE).toLowerCase() + " " +
                a.getName() + " för " + a.getPrice() + " USD misslyckades.");
        return false;
    }

    public boolean sellAnimal(Animal a) {
        if(animals.indexOf(a) > 0) {
            addFunds(a.getPrice());
            removeAnimal(a);
            System.out.println("Sålde " + a.getSpeciesName(Animal.DEFINITE).toLowerCase() + " " +
                    a.getName() + " för " + a.getPrice() + " USD.");
            return true;
        }
        return false;
    }

    // släpp lejonen lösa
    public void openGates(int rounds) {
        ArrayList<Predator> predators = new ArrayList<>();
        ArrayList<Animal> prey = new ArrayList<>();

        // dela in djur i rovdjur, flygande fåglar och byte
        final Iterator<Animal> animalIterator = animals.iterator();
        while (animalIterator.hasNext()) {
            Animal a = animalIterator.next();
            if (a instanceof Predator) {
                predators.add((Predator) a);
            }
            else if (a instanceof Bird && ((Bird) a).isFlies()) {
                System.out.println(a.getSpeciesName(Animal.DEFINITE) + " " + a.getName() + " flög iväg.");
                animalIterator.remove();
            }
            else {
                prey.add(a);
            }
        }

        // loopa attacker det antal gånger som anges i parametern rounds, eller tills alla rovdjur eller byten är döda
        int i = 0;
        while (i < rounds && predators.size() > 0 && prey.size() > 0) {

            Predator attacker = predators.get((int) (Math.random() * predators.size()));
            Animal victim = prey.get((int) (Math.random() * prey.size()));

            if(attacker.attack(victim) < 0){
                System.out.println("\u2620 " + victim.getSpeciesName(Animal.DEFINITE) + " " + victim.getName() +
                        " dödade " + attacker.getSpeciesName(Animal.DEFINITE).toLowerCase() + " " + attacker.getName() + ".");
                predators.remove(attacker);
                animals.remove(attacker);
            }

            if (victim.getHealth() < 0) {
                System.out.println("\u2620 " + attacker.getSpeciesName(Animal.DEFINITE) + " " + attacker.getName() +
                        " dödade " + victim.getSpeciesName(Animal.DEFINITE).toLowerCase() + " " + victim.getName() + ".");
                prey.remove(victim);
                animals.remove(victim);
            }

            i++;

        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(1000);
        sb.append("\n=========================================\n");
        sb.append("Zoo med ");
        sb.append(getNumberOfAnimals());
        sb.append(" djur och ");
        sb.append(getBalance());
        sb.append(" USD");
        sb.append("\n=========================================\n");
        for (Animal a : animals) {
            sb.append(a);
            sb.append("\n");
        }

        return (sb.toString());
    }
        
}
