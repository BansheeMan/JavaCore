package lesson11.task3;

public abstract class Fruit {
    private final float weight;

    Fruit(float weight){
        this.weight = weight;
    }

    public float getWeight(){
        return weight;
    }
}
