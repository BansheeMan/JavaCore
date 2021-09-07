package lesson8;

public class Main {

    public static void main(String[] args) {

        RunAndJump[] squad = {
            new Cat("Simon", 3, 10),
            new Human("Peter Parker", 15, 250),
            new Human("Jackie Chan", 2, 10),
            new Robot("T-800", 8, 20),
            new Robot("T-1000", 6, 30)
        };

        Obstruction[] obstructions = {
                new Wall(2),
                new Treadmill(9),
                new Wall(6),
                new Treadmill(30),
                new Wall(10)
        };

        for(RunAndJump member : squad){
            System.out.printf("\n%s starts overcoming obstacles\n", member.getName());
            for (Obstruction obstruction : obstructions){
                if(!(member.overcoming(obstruction))){
                    System.out.printf("For %s is GAME OVER =(\n", member.getName());
                    break;
                }
            }
            System.out.printf("%s finished overcome obstacles\n", member.getName());
        }


    }
}
