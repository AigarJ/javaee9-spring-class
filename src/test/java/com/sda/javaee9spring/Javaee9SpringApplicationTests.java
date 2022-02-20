package com.sda.javaee9spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Javaee9SpringApplicationTests {


    @Test
    void contextLoads() {
    }

    @Test
    void dependencyInjectionFirstTrial(){
        Toy realGun = new Toy("real gun");
        Child john = new Child("John", realGun);
        // dependency injection is providing all required class dependencies during creation of objects of that class
        // waterGun (of type Toy) is dependency of john (of type Child)
        // john (which is of type Child) is dependency of jason (of type Parent)
        // dependency is actually composition, so one item is made of another
        Parent jason = new Parent("Jason", john);
    }

    @Test
    void recordTest(){
        Animal animal = new Animal();
        System.out.println(animal);

        // use records instead of @Value from Lombok
        // records are immutable  - cannot modify instances of the class - so setters
        Toy realGun = new Toy("real gun");
        System.out.println(realGun);

        // child.with(favoriteToy = plasticGun; // in future Java versions
    }

    @Test
    void equalsTest(){
        Assertions.assertTrue(4 == 4);

        Animal one = new Animal();
        Animal two = new Animal();
        Animal three = one;

        // == it checks if this is the same object
        // equals by default it checks if this is the same object
        Assertions.assertFalse(one == two);
        Assertions.assertFalse(one.equals(two));

        Toy realGun1 = new Toy("real gun");
        Toy realGun2 = new Toy("real gun");
        Assertions.assertEquals(realGun1,realGun2);
    }
}

// Toy is made of name
record Toy(String name){}
//Child is composed of: name and toy
record Child(String name, Toy favouriteToy) {}
// Parent is made of (composed of): name and child
record Parent(String name, Child child){
}

class Animal{}
class Mammal extends Animal{}
class Tiger extends Mammal{}
// Tiger is Mammal
// Mammal is Animal
// We cannot say: Parent is Child (Parent don't extend Child)
