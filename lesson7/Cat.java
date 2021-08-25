package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }

    public void eat(Plate p){
        if(p.decreaseFood(appetite)){
            System.out.printf("Cat %s aet\n", name);
            satiety = true;
        }
        else {System.out.printf("Cat %s did not eat\n", name);}
    }

    public void info(){
        System.out.printf("name: %s\nappetite: %s\nsatiety: %s\n", name, appetite, satiety);
    }
}
