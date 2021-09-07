package lesson8;

public class Treadmill extends Obstruction {

    private  int length;

    public Treadmill(int length) {
        super("treadmill");
        this.length = length;
    }

    @Override
    public String getDesignation() {
        return super.getDesignation();
    }

    @Override
    public int getHeight() {
        System.out.println("wall don't has a height, only length ");
        return 0;
    }

    @Override
    public int getLength() {
        return length;
    }
}
