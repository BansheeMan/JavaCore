package lesson6;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.run(250);
        cat1.run(150);
        cat1.swim(5);
        cat1.swim(20);
        System.out.println();

        Dog dog1 = new Dog();
        dog1.run(550);
        dog1.run(499);
        dog1.swim(9);
        dog1.swim(100);
        System.out.println();

        Dog dog2 = new Dog();
        Dog dog3 = new Dog();
        Dog dog4 = new Dog();

        Cat cat2 = new Cat();
        Cat cat3 = new Cat();

        counter();
    }

    public static void counter(){
        System.out.printf("Всего создано %s животных, из них %s - котов и %s - собак", Animal.getCounter(), Cat.getCounter(), Dog.getCounter()  );
    }
}
