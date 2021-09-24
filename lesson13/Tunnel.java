package lesson13;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    Semaphore tun;

    public Tunnel(int count_car_tun) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        tun = new Semaphore(count_car_tun);
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                tun.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                tun.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
