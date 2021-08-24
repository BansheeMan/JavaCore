package lesson6;

public class Cat extends Animal{

    private static int counter;

    Cat(){
        counter++;
        Animal.setCounter(Animal.getCounter() + 1);
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public void swim(int swim) {
        super.swim(swim);
        System.out.println("Кот не умеет плавать");
    }

    @Override
    public void run(int run) {
        super.run(run);
        System.out.printf(run <= 200 ? "Кот пробежал %sм\n" : "Кот не пробежал %sм\n", run);
    }
}
