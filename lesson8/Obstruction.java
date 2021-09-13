package lesson8;

public abstract class Obstruction {

   private String designation;

    public Obstruction(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public abstract int getHeight();
    public abstract int getLength();
}
