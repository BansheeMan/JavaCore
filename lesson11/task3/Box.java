package lesson11.task3;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {

    private List<T> fruits = new ArrayList<>();

    public List<T> getFruits() {
        return fruits;
    }

    public List<T> get() {
        return fruits;
    }

    void add(T obj) {
        fruits.add(obj);
    }


    public float getWeight() {
        if (fruits.size() > 0) {
            return fruits.size() * fruits.get(0).getWeight();
        }
        return 0F;
    }

    boolean compare(Box<? extends Fruit> box){
        return this.getWeight()==box.getWeight();
    }


    public void moveAt(Box<T> box) {
        box.getFruits().addAll(fruits);
        fruits.clear();
    }

    void info() {
        if (fruits.isEmpty()) {
            System.out.println("Коробка пуста");
        } else {
            System.out.println("В коробке находятся " + fruits.get(0).toString() + " в количестве: " + fruits.size());
        }
    }

}


