package lesson7;

public class Main {

    public static void main(String[] args) {

        Plate plate = new Plate(50);
        Cat[] cats = {new Cat("Barsik", 20),
                      new Cat("HanSolo", 10),
                      new Cat("Donald McDonald", 5),
                      new Cat("Mr.White", 10),
                      new Cat("Major Payne", 6)};

        for(Cat cat: cats){
            cat.eat(plate);
            cat.info();
            System.out.println();
        }
        plate.info();
        plate.addFood(10);
        plate.info();
        plate.addFood(-10);
        plate.info();
    }
}
