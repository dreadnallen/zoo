package com.lexicon.zoo;

public class Main {

    public static void main(String[] args) {

        // initiera djur

        Baboon b1 = new Baboon(3, true, 24.0d, true, 1200);
        b1.setName("Bobo");
        b1.setPrice(4000);
        b1.setMaxSpeed(56);

        b1.setAge(-3); // triggar exception
        b1.setWeight(-24d); // triggar exception
        b1.setPrice(-4000); // triggar exception
        b1.setName(""); // triggar exception

        Baboon b2 = new Baboon(4, false,20d,true,1000);
        b2.setName("Coco");
        b2.setPrice(5000);
        b2.setMaxSpeed(49);

        Chimpanzee c1 = new Chimpanzee(4, 55, true, true, 24);
        c1.setName("Nicke Nyfiken");
        c1.setPrice(50000);
        c1.setMaxSpeed(40);

        c1.setNumOfBananas(-5); // triggar exception

        Chimpanzee c2 = new Chimpanzee(3, 40, false, true, 18);
        c2.setName("Gunilla");
        c2.setPrice(45000);
        c2.setMaxSpeed(38);

        Eagle e1 = new Eagle(6, 2, true, 180, 14);
        e1.setName("Earl");
        e1.setPrice(4000);
        e1.setMaxSpeed(160);

        Eagle e2 = new Eagle(4, 2, false, 165, 12);
        e2.setName("Eartha");
        e2.setPrice(3500);
        e2.setMaxSpeed(140);

        Elephant f1 = new Elephant(4, 1250d, false, true, 700);
        f1.setName("Dumbo");
        f1.setPrice(800000);
        f1.setMaxSpeed(40);

        Elephant f2 = new Elephant(3, 950d, false, true, 600);
        f2.setName("Diana");
        f2.setPrice(750000);
        f2.setMaxSpeed(35);

        Flamingo g1 = new Flamingo(2,2.0d,true,150,90 );
        g1.setName("Felix");
        g1.setPrice(1800);
        g1.setMaxSpeed(60);

        Flamingo g2 = new Flamingo(3, 1.5d, false, 130, 85);
        g2.setName("Felicia");
        g2.setPrice(1900);
        g2.setMaxSpeed(55);

        Ostrich o1 = new Ostrich(4,120,true,200,70);
        o1.setName("Sture");
        o1.setPrice(1200);

        Ostrich o2 = new Ostrich(3, 110, false, 180, 65);
        o2.setName("Sonja");
        o2.setPrice(1000);

        // skapa zoo med 100 000 USD i kassan och sex djur
        Zoo z = new Zoo(100_000, b1, c1, e1, f1, g1, o1);

        z.buyAnimal(b2); // babian kostar 5000 USD
        z.buyAnimal(c2); // schimpans kostar 45000 USD
        z.buyAnimal(e2); // örn kostar 3500 USD
        z.buyAnimal(f2); // elefant kostar 750000 USD - köp misslyckas
        z.buyAnimal(g2); // flamingo kostar 1900 USD
        z.buyAnimal(o2); // stork kostar 1000 USD

        z.sellAnimal(b2); // sälj babian för 5000 USD

        System.out.println(z); // skriv ut lista över samtliga djur i zoo

        Lion l1 = new Lion(3, 190, true, 80);
        l1.setName("Leif");

        Lion l2 = new Lion(4, 130, false, 70);
        l2.setName("Leia");

        z.addAnimal(l1);
        z.addAnimal(l2);

        System.out.println("Två lejon släpps lösa:\n" + l1 + l2);

        z.openGates(20);

        System.out.println(z);
    }
}
