package lesson8;

public interface RunAndJump {

    String getName();
    void jump(Wall wall);
    void run(Treadmill treadmill);
    boolean overcoming(Obstruction obstruction);
}
