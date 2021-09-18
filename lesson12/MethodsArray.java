package lesson12;

import java.util.Arrays;

public class MethodsArray {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    float[] arr = new float[SIZE];

    public  void method1(){
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        calcFormula(arr);
        System.out.println("Затраченное время: " + (System.currentTimeMillis()-a));
    }

    public void method2(){
        Arrays.fill(arr, 1);
        float[] half1 = new float[HALF];
        float[] half2 = new float[HALF];
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, half1, 0, HALF);
        System.arraycopy(arr, HALF, half2, 0, HALF);
        Thread thread1 = new Thread(() -> {
            calcFormula(half1);
        });
        Thread thread2 = new Thread(() -> {
            calcFormula(half2);
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(half1, 0, arr, 0, HALF);
        System.arraycopy(half2, 0, arr, HALF, HALF);
        System.out.println("Затраченное время: " + (System.currentTimeMillis()-a));
    }

    public static void calcFormula(float[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
