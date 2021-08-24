package lesson6;

public class Dog extends Animal{

    private static int counter;

    Dog(){
        counter++;
        Animal.setCounter(Animal.getCounter() + 1);
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public void swim(int swim) {
        super.swim(swim);
        System.out.printf(swim <= 10 ? "Пес переплыл %sм\n" : "Пес не переплыл %sм\n", swim);
    }

    @Override
    public void run(int run) {
        super.run(run);
        System.out.printf(run <= 500 ? "Пес пробежал %sм\n" : "Пес не пробежал %sм\n", run);

    }
}
