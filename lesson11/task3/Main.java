package lesson11.task3;


public class Main {
    public static void main(String[] args) {
        Orange orange1 = new Orange();

        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();
        Box<Apple> appleBox = new Box<>();

        orangeBox1.add(orange1);

        for(int i = 0; i<11; i++){
            orangeBox2.add(new Orange());
        }

        for(int i = 0; i<18; i++){
            appleBox.add(new Apple());
        }

        orangeBox1.info();
        orangeBox2.info();
        appleBox.info();

        orangeBox1.moveAt(orangeBox2);

        orangeBox1.info();
        orangeBox2.info();
        appleBox.info();

        System.out.println(orangeBox2.getWeight());
        System.out.println(appleBox.getWeight());

        System.out.println(appleBox.compare(orangeBox2));
    }

}
