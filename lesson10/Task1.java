package lesson10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Task1 {

    public static void main(String[] args) {
        String[] arr = { "Alfred", "Batman", "Catman", "Deadshot", "Joker", "Two-face", "Riddler",
                "Alfred", "Batman", "Batman", "Batman", "Catman", "Catman", "Joker",
                "Bane","Batman", "Penguin", "Firefly", "Croc","Penguin"};

        findDuplicate(arr);
    }

    public static void findDuplicate(String[] arr){
        HashSet<String> exclusive = new HashSet<>();
        for(String s: arr){
            exclusive.add(s);
        }
        System.out.printf("Всего в массиве %s слов, из которых %s уникальные\n\n", arr.length, exclusive.size());

        HashMap<String, Integer> map = new HashMap<>();
        for(String s: arr){
            if(map.containsKey(s)){
                map.put(s, map.get(s)+1);
            }
            else{
                map.put(s, 1);
            }
        }
        for(Map.Entry<String, Integer> item : map.entrySet()){
            System.out.print(item + "; ");
        }
    }
}
