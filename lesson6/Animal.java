package lesson6;

public abstract class Animal {

    private int swim, run;
    private static int counter;

    public static void setCounter(int counter) {
        Animal.counter = counter;
    }

    public static int getCounter() {
        return counter;
    }

    public void swim(int swim){ this.swim = swim;}
    public void run(int run){ this.run = run;}

}
