package ru.kirillvenediktov.philosophy.chapter15;

import ru.kirillvenediktov.philosophy.util.Generator;

import java.util.ArrayList;
import java.util.Random;

class Container {

    private final int id;
    private String description;
    private double price;

    public Container(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Container{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public void priceChange(double change) {
        price += change;
    }

    public static Generator<Container> generator = new Generator<Container>() {

        private Random random = new Random();

        @Override
        public Container next() {
            return new Container(random.nextInt(
                    1000), "Test", Math.round(random.nextDouble()* 1000.0));
        }
    };
}

class ContainerStack extends ArrayList<Container> {

    public ContainerStack(int initialCapacity) {
        Generators.fill(this, Container.generator, initialCapacity);
    }
}

class Aisle extends ArrayList<ContainerStack> {

    public Aisle(int numberOfStacks, int numberOfContainers) {
        for (int i = 0; i < numberOfStacks; i++) {
            add(new ContainerStack(numberOfContainers));
        }
    }
}

public class ContainerShip extends ArrayList<Aisle> {

    public ContainerShip(int numberOfAisles, int numberOfStacks, int numberOfContainers) {
        for (int i = 0; i < numberOfAisles; i++) {
            add(new Aisle(numberOfStacks, numberOfContainers));
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Aisle aisle : this) {
            for (ContainerStack stack : aisle) {
                for (Container container : stack) {
                    result.append((container));
                    result.append("\n");
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ContainerShip(14, 5, 10));
    }
}
