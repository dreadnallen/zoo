package com.lexicon.zoo;

public abstract class Animal {

    public static final int DEFINITE = 1;
    public static final int PLURAL = 2;

    // samtliga fält är private och därmed endast åtkomliga via getters och setters
    private int age;
    private double weight;
    private boolean sex;
    private String name;
    private int price;
    private int health = 100;
    private int maxSpeed;

    // enum för samtliga förekommande arter, deras namn och böjningar
    public enum Species {
        BABOON("en", "er") {
            public String toString() { return "Babian"; }
        },
        CHIMPANZEE("en", "er") {
            public String toString() { return "Schimpans"; }
        }, EAGLE("en", "ar") {
            public String toString() { return "Örn"; }
        }, ELEPHANT("en", "er") {
            public String toString() { return "Elefant"; }
        }, FLAMINGO("n", "r") {
            public String toString() { return "Flamingo"; }
        }, OSTRICH("en", "ar") {
            public String toString() { return "Struts"; }
        }, LION("et", "") {
            public String toString() { return "Lejon"; }
        };

        private final String definite, plural;
        public String definiteForm() { return this + definite; }
        public String pluralForm() { return this + plural; }

        Species(String definite, String plural) {
            this.definite = definite;
            this.plural = plural;
        }
    }

    public Animal() {}

    public Animal(int age, double weight){
        setAge(age);
        setWeight(weight);
    }

    public Animal(int age, double weight, boolean sex) {
        this(age, weight);
        setSex(sex);
    }

    // age
    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalArgumentException {
        try {
            if (age < 0)
                throw new IllegalArgumentException(getSpeciesName(DEFINITE) +
                        " " + getName(true) + " ålder måste ha ett positivt värde!");
            this.age = age;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // weight
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) throws IllegalArgumentException {
        try {
            if (weight < 0) throw new IllegalArgumentException(getSpeciesName(DEFINITE) +
                    " " + getName(true) + " vikt måste ha ett positivt värde!");
            this.weight = weight;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // sex
    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
    
    public String getSexSign() {
        return (sex ? "\u2642\n" : "\u2640\n");
    }

    // name
    public String getName() {
        return (name != null ? name : "Namnlös");
    }

    public String getName(boolean possessive) {
        String name = getName();
        if (possessive && (name.charAt(name.length() - 1) != 's')) { name += "s"; }
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        try {
            if (!name.matches("^[-a-zA-ZåäöüÅÄÖÜ\\s]+$"))
                throw new IllegalArgumentException(getSpeciesName(DEFINITE) +
                        " " + getName(true) + " namn måste innehålla minst ett tecken. " +
                        "Endast bokstäver, blanksteg och bindestreck är tillåtna.");
            this.name = name;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // price
    public int getPrice() { return price; }
    public void setPrice(int price) throws IllegalArgumentException {
        try {
            if (price < 0) throw new IllegalArgumentException(getSpeciesName(DEFINITE) +
                    " " + getName(true) + " pris måste ha ett positivt värde!");
            this.price = price;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // health
    public int getHealth() { return health; }
    public void decreaseHealth(int health) { this.health -= health; }

    // maxSpeed
    public int getMaxSpeed() {
        return maxSpeed;
    }
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }


    // species
    protected abstract Animal.Species getSpecies();

    public String getSpeciesName() { return getSpecies().toString(); }

    public String getSpeciesName(int form) {
        String name = getSpecies().toString();
        switch (form) {
            case DEFINITE:
                name = getSpecies().definiteForm();
                break;
            case PLURAL:
                name = getSpecies().pluralForm();
                break;
        }
        return name;
    }

    @Override
    public String toString() {
        return ("\n" + getSpeciesName() + ": " + getName() + " " + getSexSign() +
        "-----------------------------------------\n" +
        "hälsa:\t\t" + health + "%\n" +
        "ålder:\t\t" + age + " år\n" +
        "vikt:\t\t" + weight + " kg\n") +
        (getMaxSpeed() > 0 ? "springer:\t" + getMaxSpeed() + " km/h\n" : "");
    }
}
