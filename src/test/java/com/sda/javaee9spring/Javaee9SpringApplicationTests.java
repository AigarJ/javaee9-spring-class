package com.sda.javaee9spring;

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
