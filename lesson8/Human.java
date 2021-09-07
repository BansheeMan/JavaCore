package lesson8;

public class Human implements RunAndJump{

    private String name;
    private int maxJump;
    private int maxRun;

    public Human(String name, int maxJump, int maxRun) {
        this.name = name;
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }

    public String getName() {
        return name;
    }

    public int getMaxJump() {
        return maxJump;
    }

    public int getMaxRun() {
        return maxRun;
    }

    @Override
    public void jump(Wall wall) {
        System.out.println(getName() + " jumped " + wall.getDesignation());
    }

    @Override
    public void run(Treadmill treadmill) {
        System.out.println(getName() + " ran " + treadmill.getDesignation());
    }

    @Override
    public boolean overcoming(Obstruction obstruction) {
        boolean a = false;
        if(obstruction instanceof Treadmill) {
            if (getMaxRun() >= ((Treadmill) obstruction).getLength()) {
                run(((Treadmill) obstruction));
                a = true;
            }
            else { System.out.println("The obstacle could not be overcome");
                a = false;
            }
        }
        else if(obstruction instanceof Wall) {
            if (getMaxJump() >= ((Wall) obstruction).getHeight()) {
                jump(((Wall) obstruction));
                a = true;
            }
            else { System.out.println("The obstacle could not be overcome");
                a = false;
            }
        }
        return a;
    }
}
