package lesson10;

import java.util.ArrayList;
import java.util.HashMap;

public class Task2 {

    public static void main(String[] args) {
        addContact("Скорая помощь", 103);
        addContact("Скорая помощь", 911);
        addContact("Милиция", 102);
        addContact("Милиция", 911);
        addContact("Милиция", 2222);
        addContact("Семейный психолог", 33333344);
        addContact("Мама", 3951196);
        addContact("Папа", 7658434);
        addContact("Доставка пиццы(и пива)", 3457852);
        addContact("Билл Косби", 6644669);
        addContact("Билл Косби", 5544559);

        getContact("Семейный психолог");
        getContact("Милиция");
        getContact("Билл Косби");
        getContact("Доставка пиццы(и пива)");

        getContact("Тупак");
    }

    private static HashMap<String, ArrayList<Integer>> telbook = new HashMap<>();

    public static void addContact(String name, int number) {
        if (telbook.containsKey(name)) {
            telbook.get(name).add(number);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(number);
            telbook.put(name, list);
        }
    }

    public static void getContact(String name) {
        if(telbook.containsKey(name)){
            System.out.print(name + " ————— ");
            for (int i: telbook.get(name)){
                System.out.print(i+"; ");
            }
            System.out.println();
        } else {
            System.out.println("У ВАС НЕТ ТАКОГО КОНТАКТА((((");
        }
    }
}
