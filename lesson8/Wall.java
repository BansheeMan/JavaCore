package lesson8;

public class Wall extends Obstruction  {

    private  int height;

    public Wall(int height) {
        super("wall");
        this.height = height;
    }

    @Override
    public String getDesignation() {
        return super.getDesignation();
    }
    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getLength() {
        System.out.println("wall don't has a length, only height ");
        return 0;
    }
}
