package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void addFood(int food) {
        if (food<=0){
            System.out.println("We can only add food");
            return;
        }
        this.food += food;
        System.out.println("Food was added to the plate");
    }

    public boolean decreaseFood(int n) {
        if(n>food){
            System.out.println("Not enough food");
            return false;
        }
        food -=n;
        return true;
    }

    public void info(){
        System.out.println("plate: " + food);
    }
}
